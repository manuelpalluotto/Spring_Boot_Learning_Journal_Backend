package com.academy.manu.learning.journal.Verification;

import com.academy.manu.learning.journal.Classrooms;
import com.academy.manu.learning.journal.Person.Person;
import com.academy.manu.learning.journal.Person.PersonDTO;
import com.academy.manu.learning.journal.Person.PersonRepository;
import com.academy.manu.learning.journal.Role;
import com.academy.manu.learning.journal.Security.JwtService;
import com.academy.manu.learning.journal.Security.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class AuthController {
    private final JwtService jwtService;
    private final EmailService emailService;
    private final PersonRepository personRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authMan;
    private final VerificationTokenRepo tokenRepo;
    private final VerificationTokenRepo verificationTokenRepo;

    public AuthController(JwtService jwtService, PersonRepository personRepo, PasswordEncoder passwordEncoder, AuthenticationManager authMan, VerificationTokenRepo tokenRepo, EmailService emailService, VerificationTokenRepo verificationTokenRepo) {
        this.jwtService = jwtService;
        this.personRepo = personRepo;
        this.passwordEncoder = passwordEncoder;
        this.authMan = authMan;
        this.tokenRepo = tokenRepo;
        this.emailService = emailService;
        this.verificationTokenRepo = verificationTokenRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PersonDTO personDTO) {

        String encodedPassword = passwordEncoder.encode(personDTO.password());
        Person person = Person.builder()
                .username(personDTO.username())
                .password(encodedPassword)
                .email(personDTO.email())
                .role(personDTO.role()
                        .equals("ROLE_ADMIN") ? Role.ROLE_ADMIN : Role.ROLE_USER)
                .classroom(personDTO.classroom().equals("TEACHER") ? Classrooms.TEACHER : Classrooms.STUDENT)
                .verified(personDTO.verified())
                .build();

        personRepo.save(person);

        VerificationToken verificationToken = new VerificationToken(person);
        tokenRepo.save(verificationToken);

        emailService.sendVerificationEmail(person.getEmail(), verificationToken.getToken());

        return ResponseEntity.ok("User registered! Verification email sent.");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {

        Person person = personRepo.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        if (!person.isVerified()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("error", "Email not verified"));
        } else {
            authMan.authenticate( UsernamePasswordAuthenticationToken.unauthenticated(request.getUsername(), request.getPassword()) );
            person.setVerified(true);
            personRepo.save(person);
            String token = JwtService.generateToken(person);
            return ResponseEntity.ok(Map.of("token", token));
        }

    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail (@RequestParam("token") String token) {
        VerificationToken verificationToken = verificationTokenRepo.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token not found"));

        Person person = verificationToken.getPerson();
        person.setVerified(true);
        personRepo.save(person);

        verificationTokenRepo.delete(verificationToken);

        return ResponseEntity.ok("Email verified successfully. You can now login.");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logged out successfully");
    }
}

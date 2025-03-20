package com.academy.manu.learning.journal.Security;

//import com.academy.manu.learning.journal.Classrooms;
import com.academy.manu.learning.journal.Person.Person;
import com.academy.manu.learning.journal.Person.PersonDTO;
import com.academy.manu.learning.journal.Person.PersonRepository;
import com.academy.manu.learning.journal.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class AuthController {
    private final JwtService jwtService;
    private final PersonRepository personRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authMan;

    public AuthController(JwtService jwtService, PersonRepository personRepo, PasswordEncoder passwordEncoder, AuthenticationManager authMan) {
        this.jwtService = jwtService;
        this.personRepo = personRepo;
        this.passwordEncoder = passwordEncoder;
        this.authMan = authMan;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PersonDTO personDTO) {
        Person person = Person.builder()
                .username(personDTO.username())
                .password(personDTO.password())
                .email(personDTO.email())
                .role(
                        personDTO.role().equals("ROLE_ADMIN") ? Role.ROLE_ADMIN : Role.ROLE_USER
                )
//                .classroom(
//                        personDTO.classroom().equals("TEACHER") ? Classrooms.TEACHER : Classrooms.STUDENT
//                )
                .build();
        personRepo.save(person);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        authMan.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(request.getUsername(), request.getPassword()));
        Person person = personRepo.findByUsername(request.getUsername())
                .orElseThrow();
        String token = JwtService.generateToken(person);
        System.out.println(token);
        return ResponseEntity.ok(Map.of("token", token));
    }
}

package com.academy.manu.learning.journal.Security;

import com.academy.manu.learning.journal.Person.Person;
import com.academy.manu.learning.journal.Person.PersonRepository;
import com.academy.manu.learning.journal.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final PersonRepository personRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthController(PersonRepository personRepo, PasswordEncoder passwordEncoder) {
        this.personRepo = personRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(Role.ROLE_USER);
        personRepo.save(person);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Person person = personRepo.findByUsername(request.getUsername());

        if (person != null && passwordEncoder.matches(request.getPassword(), person.getPassword())) {
            return JwtUtil.generateToken(person.getUsername());
        }
    return "Invalid credentials";
    }

}

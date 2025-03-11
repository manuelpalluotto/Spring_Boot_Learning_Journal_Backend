package com.academy.manu.learning.journal.Security;

import com.academy.manu.learning.journal.User.User;
import com.academy.manu.learning.journal.User.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final com.academy.manu.learning.journal.Security.JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, com.academy.manu.learning.journal.Security.JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "User erfolgreich registriert";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User foundUser = userService.findFirstByUsername(user.getUsername());
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Falsche Anmeldedaten");
        }
    }
}

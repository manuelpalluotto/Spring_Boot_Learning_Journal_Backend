//package com.academy.manu.learning.journal;
//
//import com.academy.manu.learning.journal.Security.LoginRequest;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//
//    private final AuthenticationManager authenticationManager;
//
//    public LoginController(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @PostMapping
//    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
//            );
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            HttpSession session = request.getSession(true);
//            String sessionID = session.getId();
//
//            System.out.println("User authenticated: " + authentication.getName());
//            System.out.println("Session ID: " + sessionID);
//            System.out.println("Session Attributes: " + session.getAttributeNames());
//
//            return ResponseEntity.ok(Map.of("sessionID", sessionID));
//        } catch (Exception e) {
//            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
//        }
//    }
//}

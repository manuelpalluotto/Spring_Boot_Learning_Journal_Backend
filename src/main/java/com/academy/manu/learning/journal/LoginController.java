package com.academy.manu.learning.journal;


import com.academy.manu.learning.journal.Person.PersonRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {


    @PostMapping
    public ResponseEntity<Map<String, String>> login(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String sessionID = session.getId();
        System.out.println("Session ID: " + session.getId());
        return ResponseEntity.ok(Map.of("sessionID", sessionID));
    }

}

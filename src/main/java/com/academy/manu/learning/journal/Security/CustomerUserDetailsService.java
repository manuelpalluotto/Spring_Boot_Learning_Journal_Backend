package com.academy.manu.learning.journal.Security;

import com.academy.manu.learning.journal.User.User;
import com.academy.manu.learning.journal.User.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomerUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Benutzer anhand des Benutzernamens suchen
        User user = userRepo.findFirstByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Gib den Benutzer als UserDetails zurück (kann auch CustomUserDetails sein)
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}

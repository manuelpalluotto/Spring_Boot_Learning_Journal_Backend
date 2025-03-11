package com.academy.manu.learning.journal.User;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.UUID;

public class CustomUserDetails extends User{
    private UUID id;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, UUID id) {
        super(username, password, authorities);
        this.id = id;
    }
}

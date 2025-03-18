package com.academy.manu.learning.journal.Security;

import com.academy.manu.learning.journal.Person.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserPrincipal implements UserDetails {
    private final Person person;

    public MyUserPrincipal(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Use the person's role to create a GrantedAuthority
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole().name()));
    }

    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // or implement based on your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // or implement based on your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // or implement based on your requirements
    }

    @Override
    public boolean isEnabled() {
        return true;  // or implement based on your requirements
    }
}
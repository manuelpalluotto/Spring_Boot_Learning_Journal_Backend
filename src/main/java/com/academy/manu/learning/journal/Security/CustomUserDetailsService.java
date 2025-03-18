package com.academy.manu.learning.journal.Security;

import com.academy.manu.learning.journal.Person.Person;
import com.academy.manu.learning.journal.Person.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;

    public CustomUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> personOpt = personRepository.findByUsername(username);
        if (personOpt.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        } else {
            return new MyUserPrincipal(personOpt.get());
        }
    }
}
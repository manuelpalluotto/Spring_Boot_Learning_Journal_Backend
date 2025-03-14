package com.academy.manu.learning.journal;

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



    public UserDetails loadUserByUsername(String username) {
        Person person = personRepository.findByUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new MyUserPrincipal(person);
        }

    }
}

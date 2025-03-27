package com.academy.manu.learning.journal.Person;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllUsers() {
        return personRepository.findAll();
    }

    public Person findById(String userId) {
        return personRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

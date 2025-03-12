package com.academy.manu.learning.journal.Person;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addUser(Person person) {
        personRepository.save(person);
    }

    public List<Person> getAllUsers() {
        return personRepository.findAll();
    }
}

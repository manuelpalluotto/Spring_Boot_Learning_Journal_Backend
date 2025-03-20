package com.academy.manu.learning.journal.Person;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/users")
    public List<Person> getAllUsers() {
        return personService.getAllUsers();
    }

}

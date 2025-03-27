package com.academy.manu.learning.journal.Entries;


import com.academy.manu.learning.journal.Person.Person;
import com.academy.manu.learning.journal.Person.PersonRepository;
import com.academy.manu.learning.journal.Person.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {

    private final EntryService entryService;
    private final PersonService personService;

    public EntryController(EntryService entryService, PersonRepository personRepository, PersonService personService) {
        this.entryService = entryService;
        this.personService = personService;
    }

    @GetMapping
    public List<Entry> getEntries() {
        return entryService.getEntries();
    }

    @PostMapping
    public void addEntry(@RequestBody EntryDTO entryDTO) {
        if (entryDTO.getUserId() == null || entryDTO.getUserId().isEmpty()) {
            throw new IllegalArgumentException("userId is required");
        }
        Entry entry = entryDTO.toEntity(personService);
        entryService.addEntry(entry);
    }

    @PutMapping
    public void updateEntry(@RequestBody EntryDTO entrydto) {
        entryService.updateEntry(entrydto);
        System.out.println("sadf");
    }
}

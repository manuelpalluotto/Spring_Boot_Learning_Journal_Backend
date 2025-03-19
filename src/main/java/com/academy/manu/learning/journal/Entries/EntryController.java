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

    @PostMapping()
    public void addEntry(@RequestBody Entry entry) {
        String userId = entry.getPerson().getId(); // `userId` aus dem Entry-Objekt extrahieren
        entryService.addEntry(entry, userId);
    }
}

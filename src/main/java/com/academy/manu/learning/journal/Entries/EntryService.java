package com.academy.manu.learning.journal.Entries;

import com.academy.manu.learning.journal.Person.Person;
import com.academy.manu.learning.journal.Person.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EntryService {

    private final EntryRepository entryRepository;
    private final PersonService personService;

    public EntryService(EntryRepository entryRepository, PersonService personService) {
        this.entryRepository = entryRepository;
        this.personService = personService;
    }

    public void addEntry(Entry entry,@RequestParam String userId) {
        entryRepository.save(entry);
    }



    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }
}

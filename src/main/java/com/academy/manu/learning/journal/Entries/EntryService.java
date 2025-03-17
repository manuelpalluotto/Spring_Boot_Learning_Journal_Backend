package com.academy.manu.learning.journal.Entries;

import com.academy.manu.learning.journal.Person.Person;
import com.academy.manu.learning.journal.Person.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    private final EntryRepository entryRepository;
    private final PersonService personService;

    public EntryService(EntryRepository entryRepository, PersonService personService) {
        this.entryRepository = entryRepository;
        this.personService = personService;
    }

    public void addEntry(Entry entry, String userId) {
        Person person = personService.findById(entry.getPerson().getId());
        entry.setPerson(person);
        entryRepository.save(entry);
    }

    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }
}

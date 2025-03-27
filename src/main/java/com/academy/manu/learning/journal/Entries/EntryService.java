package com.academy.manu.learning.journal.Entries;

import com.academy.manu.learning.journal.Person.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    private final EntryRepository entryRepository;
    private final PersonService personService;

    public EntryService(EntryRepository entryRepository, PersonService personService) {
        this.entryRepository = entryRepository;
        this.personService = personService;
    }

    public void addEntry(Entry entry) {
        entryRepository.save(entry);
    }



    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }

    public void updateEntry(EntryDTO entrydto) {

        String entryID = entrydto.getId();

        Optional<Entry> entry = entryRepository.findById(entryID);
        if (entry.isPresent()) {


            Entry updatedEntry = entry.get();


            updatedEntry.setAuthor(entrydto.getAuthor());
            updatedEntry.setEntry(entrydto.getEntry());
            updatedEntry.setTimestamp(String.valueOf(System.currentTimeMillis()));
            entryRepository.save(updatedEntry);


        } else {
            throw new IllegalArgumentException("Entry not found");

        }

    }






}

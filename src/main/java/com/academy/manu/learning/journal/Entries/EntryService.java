package com.academy.manu.learning.journal.Entries;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public void addEntry(Entry entry) {
        entryRepository.save(entry);
    }

    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }
}

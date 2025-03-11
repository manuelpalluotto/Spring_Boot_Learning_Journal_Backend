package com.academy.manu.learning.journal.Entry;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EntryService {
    private final EntryRepo entryRepo;

    public EntryService(EntryRepo entryRepo) {
        this.entryRepo = entryRepo;
    }

    public List<Entry> findAll() {
        return entryRepo.findAll();
    }

    public void addEntry(Entry entry) {
        entryRepo.save(entry);
    }
}

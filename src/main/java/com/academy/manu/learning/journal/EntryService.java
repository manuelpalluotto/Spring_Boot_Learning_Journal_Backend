package com.academy.manu.learning.journal;

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

    public void save(@RequestBody Entry entry) {
        if (entry.getUser() != null && entry.getUser().getUsername() != null) {
            User user = entry.getUser();
            if (user != null) {
                entry.setUser(user);
                entryRepo.save(entry);
            } else {
                throw new RuntimeException("User nicht gefunden: " + entry.getUser().getUsername());
            }
        } else {
            throw new RuntimeException("User fehlt in der Anfrage");
        }
    }
}


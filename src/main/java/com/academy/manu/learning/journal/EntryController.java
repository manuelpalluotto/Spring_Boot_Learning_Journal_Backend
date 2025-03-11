package com.academy.manu.learning.journal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntryController {
    public final EntryService entryService;


    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/entries")
    public List<Entry> getEntries() {
        return entryService.findAll();
    }

    @PostMapping("/entries")
    public void addEntry(@RequestBody Entry entry) {
        entryService.save(entry);
    }

}

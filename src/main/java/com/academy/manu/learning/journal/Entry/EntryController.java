package com.academy.manu.learning.journal.Entry;

import com.academy.manu.learning.journal.User.User;
import com.academy.manu.learning.journal.User.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entries")
public class EntryController {

    private final EntryService entryService;
    private final UserService userService;

    public EntryController(EntryService entryService, UserService userService) {
        this.entryService = entryService;
        this.userService = userService;
    }

    @GetMapping
    public List<Entry> getEntries() {
        return entryService.findAll();
    }

    @PostMapping("/entries")
    public void createEntry(@RequestBody Entry entry) {
        entryService.addEntry(entry);
    }
}

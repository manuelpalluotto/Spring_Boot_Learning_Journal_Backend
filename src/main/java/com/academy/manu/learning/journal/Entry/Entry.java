package com.academy.manu.learning.journal.Entry;

import com.academy.manu.learning.journal.User.User;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "entry", nullable = false)
    private String entry;

    @Column(name = "author", nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Entry() {}

    public Entry(String entry, String author, User user) {
        this.entry = entry;
        this.author = author;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.academy.manu.learning.journal;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "entry")
    private String entry;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "username", nullable = false)
    private User user;

    public Entry() {
    }

    public Entry(UUID id, String entry, User user) {
        this.id = id;
        this.entry = entry;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

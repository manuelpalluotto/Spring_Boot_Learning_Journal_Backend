package com.academy.manu.learning.journal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EntryRepo extends JpaRepository<Entry, UUID> {
}

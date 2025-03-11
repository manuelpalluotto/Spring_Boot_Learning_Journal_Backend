package com.academy.manu.learning.journal.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EntryRepo extends JpaRepository<Entry, UUID> {
}

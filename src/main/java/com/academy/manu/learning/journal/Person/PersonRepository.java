package com.academy.manu.learning.journal.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findByUsername(String username);
}

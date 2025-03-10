package com.academy.manu.learning.journal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

    User findFirstByUsername(String Manu);
}

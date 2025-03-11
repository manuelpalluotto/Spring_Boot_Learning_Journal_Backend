package com.academy.manu.learning.journal.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {


   public User findByUsername(String username);
}

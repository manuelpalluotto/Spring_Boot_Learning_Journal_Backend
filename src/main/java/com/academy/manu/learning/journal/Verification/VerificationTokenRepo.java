package com.academy.manu.learning.journal.Verification;

import com.academy.manu.learning.journal.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {


    public Optional<VerificationToken> findByToken(String token);

    void deleteByPerson(Person person);
}

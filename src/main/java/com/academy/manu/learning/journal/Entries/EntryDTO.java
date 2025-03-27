package com.academy.manu.learning.journal.Entries;
import com.academy.manu.learning.journal.Person.Person;
import com.academy.manu.learning.journal.Person.PersonService;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryDTO {
    private String id;
    private String author;
    private String entry;
    private String timestamp;
    private String userId;

    public Entry toEntity(PersonService personService) {
        Person person = personService.findById(userId);
        if (person == null) {
            throw new IllegalArgumentException("Invalid userId: Person not found");
        }


        return Entry.builder()
                .author(author)
                .entry(entry)
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .person(person)
                .build();
    }
}

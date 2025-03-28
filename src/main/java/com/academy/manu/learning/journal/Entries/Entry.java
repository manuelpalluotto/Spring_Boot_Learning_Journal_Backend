package com.academy.manu.learning.journal.Entries;

import com.academy.manu.learning.journal.Person.Person;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "char(36)")
    private String id;

    @Column(name = "author")
    private String author;

    @Column(name = "entry")
    private String entry;

    @Column(name = "timestamp")
    private String timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", columnDefinition = "char(36)")
    private Person person;

    public String getUserId() {
        return person != null ? person.getId() : null;
    }

}

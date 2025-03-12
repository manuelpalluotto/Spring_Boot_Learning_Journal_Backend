package com.academy.manu.learning.journal.Entries;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "char(36)")
    private String id;

    @Column(name = "author")
    private String author;

    @Column(name = "entry")
    private String entry;

    @Column(name = "user_id", columnDefinition = "char(36)")
    private String userId;

}

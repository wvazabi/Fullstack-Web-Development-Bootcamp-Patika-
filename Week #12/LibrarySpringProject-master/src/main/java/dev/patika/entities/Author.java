package dev.patika.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id" , columnDefinition = "serial")
    private long id;

    @Column(name = "author_name")
    @NotNull
    private String name;

    @Column(name = "author_birth_date")
    @NotNull
    private int birthDate;

    @Column(name = "author_country")
    @NotNull
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;


}

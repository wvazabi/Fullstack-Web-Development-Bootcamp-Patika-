package dev.patika.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id" , columnDefinition = "serial")
    private long id;

    @Column(name = "category_name")
    @NotNull
    private String name;

    @Column(name = "category_description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "category2book",
            joinColumns = {@JoinColumn(name = "category2book_category_id")},
            inverseJoinColumns = {@JoinColumn(name = "category2book_book_id")}
            )
    private List<Book> bookList;
}

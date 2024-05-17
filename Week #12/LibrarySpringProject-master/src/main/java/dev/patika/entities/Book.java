package dev.patika.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id" , columnDefinition = "serial")
    private long id;

    @Column(name = "book_name")
    @NotNull
    private String name;
    @Column(name = "book_publication_year")
    @NotNull
    private int publicationYear;
    @Column(name = "book_stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "book_author_id" , referencedColumnName = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;

    @ManyToMany(mappedBy = "bookList")
    private List<Category> categoryList;

}

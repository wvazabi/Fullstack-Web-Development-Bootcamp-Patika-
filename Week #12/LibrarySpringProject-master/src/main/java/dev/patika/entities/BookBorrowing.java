package dev.patika.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "book_borrowings")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_borrowing_id" , columnDefinition = "serial")
    private long id;

    @Column(name = "book_borrowing_name")
    @NotNull
    private String borrowerName;

    @Column(name = "book_borrowing_email")
    private String borrowerEmail;

    @Column(name = "book_borrowing_start_date")
    private Date borrowingDate;

    @Column(name = "book_borrowing_finish_date")
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}

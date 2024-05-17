package dev.patika.repository;

import dev.patika.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookBorrowingRepository extends JpaRepository<BookBorrowing, Long> {
}
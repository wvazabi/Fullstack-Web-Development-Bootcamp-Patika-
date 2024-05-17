package dev.patika.repository;

import dev.patika.entities.Book;
import dev.patika.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategoriesContains(Category category);
}
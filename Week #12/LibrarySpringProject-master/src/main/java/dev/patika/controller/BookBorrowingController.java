package dev.patika.controller;

import dev.patika.business.abstracts.CrudService;
import dev.patika.dto.request.BookBorrowingUpdateRequest;
import dev.patika.entities.BookBorrowing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookborrowings")
public class BookBorrowingController {

    private final CrudService<BookBorrowing> bookBorrowingService;
    private ModelMapper modelMapper;

    @Autowired
    public BookBorrowingController(CrudService<BookBorrowing> bookBorrowingService) {
        this.bookBorrowingService = bookBorrowingService;
    }

    @GetMapping("/{id}")
    public BookBorrowing getById(@PathVariable Long id) {
        return bookBorrowingService.getById(id);
    }

    @GetMapping("")
    public List<BookBorrowing> getAll() {
        return bookBorrowingService.getAll();
    }

    @PostMapping("")
    public BookBorrowing add(@RequestBody BookBorrowing bookBorrowing) {
        return bookBorrowingService.save(bookBorrowing);
    }

    @PutMapping("/{id}")
    public BookBorrowing update(@PathVariable Long id, @RequestBody BookBorrowingUpdateRequest bookBorrowingUpdate) {
        BookBorrowing newBookBorrowing = this.modelMapper.map(bookBorrowingUpdate, BookBorrowing.class);
        newBookBorrowing.setId(bookBorrowingUpdate.getId());
        return bookBorrowingService.update(newBookBorrowing);
    }

    @DeleteMapping("/{id}")
    public void deleteBookBorrowing(@PathVariable Long id) {
        bookBorrowingService.delete(id);
    }
}

package dev.patika.controller;

import dev.patika.business.abstracts.CrudService;
import dev.patika.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final CrudService<Author> authorService;

    @Autowired
    public AuthorController(CrudService<Author> authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @GetMapping("")
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @PostMapping("")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id); // Ensure that the author ID is set correctly
        return authorService.update(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
    }
}

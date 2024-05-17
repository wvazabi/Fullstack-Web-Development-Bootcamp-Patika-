package dev.patika.business.concrates;

import dev.patika.business.abstracts.CrudService;
import dev.patika.entities.Book;
import dev.patika.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements CrudService<Book> {

    private final IBookRepository ibookRepository;

    public BookManager(IBookRepository ibookRepository) {
        this.ibookRepository = ibookRepository;
    }


    @Override
    public Book getById(Long id) {
        return ibookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAll() {
        return ibookRepository.findAll();
    }

    @Override
    public Book save(Book entity) {
        return ibookRepository.save(entity);
    }

    @Override
    public Book update(Book entity) {
        // Assuming that the entity is managed and updated elsewhere
        return ibookRepository.save(entity);
    }

    @Override
    public String delete(Long id) {
        ibookRepository.deleteById(id);
        return null;
    }
}
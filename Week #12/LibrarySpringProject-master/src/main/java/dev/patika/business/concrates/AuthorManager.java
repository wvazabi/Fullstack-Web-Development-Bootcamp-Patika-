package dev.patika.business.concrates;

import dev.patika.business.abstracts.CrudService;
import dev.patika.entities.Author;
import dev.patika.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorManager implements CrudService<Author> {

    private final IAuthorRepository iauthorRepository;

    @Autowired
    public AuthorManager(IAuthorRepository iauthorRepository) {
        this.iauthorRepository = iauthorRepository;
    }

    @Override
    public Author getById(Long id) {
        return iauthorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> getAll() {
        return iauthorRepository.findAll();
    }

    @Override
    public Author save(Author entity) {
        return iauthorRepository.save(entity);
    }

    @Override
    public Author update(Author entity) {
        // Assuming that the entity is managed and updated elsewhere
        return iauthorRepository.save(entity);
    }

    @Override
    public String delete(Long id) {
        iauthorRepository.deleteById(id);
        return null;
    }
}

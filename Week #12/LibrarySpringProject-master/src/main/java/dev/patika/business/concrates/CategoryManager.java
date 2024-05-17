package dev.patika.business.concrates;

import dev.patika.business.abstracts.CrudService;
import dev.patika.entities.Book;
import dev.patika.entities.Category;
import dev.patika.repository.IBookRepository;
import dev.patika.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CrudService<Category> {

    private final ICategoryRepository icategoryRepository;
    private final IBookRepository ibookRepository;

    @Autowired
    public CategoryManager(ICategoryRepository icategoryRepository, IBookRepository ibookRepository) {
        this.icategoryRepository = icategoryRepository;
        this.ibookRepository = ibookRepository;
    }

    @Override
    public Category getById(Long id) {
        return icategoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return icategoryRepository.findAll();
    }

    @Override
    public Category save(Category entity) {
        return icategoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        // Assuming that the entity is managed and updated elsewhere
        return icategoryRepository.save(entity);
    }

    @Override
    public String delete(Long id) {
        Category category = icategoryRepository.findById(id).orElse(null);
        if (category == null) {
            return "Kategori bulunamadı.";
        }

        List<Book> booksInCategory = ibookRepository.findByCategoriesContains(category);
        if (!booksInCategory.isEmpty()) {
            return "Bu kategoriye ait kitap var. Bu kategori silinemedi.";
        }

        icategoryRepository.deleteById(id);
        return "Kategori başarıyla silindi.";
    }

}
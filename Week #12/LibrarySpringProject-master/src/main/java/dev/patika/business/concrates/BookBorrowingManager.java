package dev.patika.business.concrates;

import dev.patika.business.abstracts.CrudService;
import dev.patika.entities.Book;
import dev.patika.entities.BookBorrowing;
import dev.patika.repository.IBookBorrowingRepository;
import dev.patika.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingManager implements CrudService<BookBorrowing> {

    private final IBookBorrowingRepository ibookBorrowingRepository;
    private final IBookRepository ibookRepository;

    @Autowired
    public BookBorrowingManager(IBookBorrowingRepository ibookBorrowingRepository, IBookRepository ibookRepository) {
        this.ibookBorrowingRepository = ibookBorrowingRepository;
        this.ibookRepository = ibookRepository;
    }

    @Override
    public BookBorrowing getById(Long id) {
        return ibookBorrowingRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookBorrowing> getAll() {
        return ibookBorrowingRepository.findAll();
    }

    @Override
    public BookBorrowing save(BookBorrowing entity) {
        Book book = entity.getBook();
        int stock = book.getStock();
        if (stock <= 0) {
            throw new RuntimeException("Stokta yeterli kitap bulunmamaktadır.");
        }
        book.setStock(stock - 1); // Kitap stoktan düşürülüyor
        ibookRepository.save(book); // Stok güncelleniyor
        return ibookBorrowingRepository.save(entity); // Ödünç alma kaydı yapılıyor
    }

    @Override
    public BookBorrowing update(BookBorrowing entity) {
        // Assuming that the entity is managed and updated elsewhere
        return ibookBorrowingRepository.save(entity);
    }

    @Override
    public String delete(Long id) {
        ibookBorrowingRepository.deleteById(id);
        return null;
    }
}

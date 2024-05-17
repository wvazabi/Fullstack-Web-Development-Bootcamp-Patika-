package com.engenes.ecommerce.business.concretes;

import com.engenes.ecommerce.business.abstracts.ICategoryService;
import com.engenes.ecommerce.core.exception.NotFoundException;
import com.engenes.ecommerce.core.utilies.Msg;
import com.engenes.ecommerce.dao.CategoryRepo;
import com.engenes.ecommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class CategoryManager implements ICategoryService {

    // hocanın en çok yaptığı dependancy injection biçimi
    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(int id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        //pageable sınıfı var yani kaçıncı sayfa bir sayfada kaçtane olması gerektiğini bu şekilde yazıyoruz
        Pageable pageable = PageRequest.of(page,pageSize);
        //peagination ı kendi otomatik yaparım diyor bu şekilde
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return this.categoryRepo.save(category);
    }

    @Override
    public boolean delete(int id) {
        //bir exxception varsa hata alırsak true değeri dönmüyecek hata almaya devam edecek
        Category category = this.get(id);
        this.categoryRepo.delete(category);
        return true;
    }


}

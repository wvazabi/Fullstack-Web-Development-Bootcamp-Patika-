package com.engenes.ecommerce.business.concretes;

import com.engenes.ecommerce.business.abstracts.ICategoryService;
import com.engenes.ecommerce.dao.CategoryRepo;
import com.engenes.ecommerce.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {

    // hocanın en çok yaptığı dependancy injection biçimi
    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return null;
    }
}

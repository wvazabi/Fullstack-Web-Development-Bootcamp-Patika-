package com.engenes.ecommerce.api;


import com.engenes.ecommerce.business.abstracts.ICategoryService;
import com.engenes.ecommerce.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;


    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    // valid diyerek validation anatosyon veriyoruz bunu kontrol et diyoruz. Notnull u kontrol ediyoruz
    public Category save(@Valid @RequestBody Category category) {
        return this.categoryService.save(category);
    }
}

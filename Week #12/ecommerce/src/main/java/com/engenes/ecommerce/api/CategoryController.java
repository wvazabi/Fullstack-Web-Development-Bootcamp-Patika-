package com.engenes.ecommerce.api;


import com.engenes.ecommerce.business.abstracts.ICategoryService;
import com.engenes.ecommerce.core.config.modelMaper.IModelMapperService;
import com.engenes.ecommerce.core.result.Result;
import com.engenes.ecommerce.core.result.ResultData;
import com.engenes.ecommerce.core.utilies.ResultHelper;
import com.engenes.ecommerce.dto.request.category.CategorySaveRequest;
import com.engenes.ecommerce.dto.request.category.CategoryUpdateRequest;
import com.engenes.ecommerce.dto.response.CursorResponse;
import com.engenes.ecommerce.dto.response.category.CategoryResponse;
import com.engenes.ecommerce.entities.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;


    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    // valid diyerek validation anatosyon veriyoruz bunu kontrol et diyoruz. Notnull u kontrol ediyoruz
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        CategoryResponse categoryResponse = this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class);
        return ResultHelper.created(categoryResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> get(@PathVariable("id") int id) {
        Category category = this.categoryService.get(id);
        CategoryResponse categoryResponse = this.modelMapper.forResponse().map(category, CategoryResponse.class);
        return ResultHelper.success(categoryResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponse>> cursor(
            // query stringler ile verileri alıyoruz
            //methodun parametreleri, required false yaparak zorunda olmadıgını söylüyoruz, değer yoksa ilk sayfa
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            // default olarak 10 tane veri getir diyoruz
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize

    ) {

        Page<Category> categoryPage = this.categoryService.cursor(page, pageSize);
        // normalde strema pi sonra mapleme yaparız ama bunun içinde stream var
        Page<CategoryResponse> categoryResponsePage = categoryPage
                //herbir kategoryi kategory response a dönüştüüryor
                .map(category -> this.modelMapper.forResponse().map(category, CategoryResponse.class));

        // Result helper ın içine metod tanımaldık tekrar yazmamak için
//        CursorResponse<CategoryResponse> cursor = new CursorResponse<>();
//        cursor.setItems(categoryResponsePage.getContent());
//        cursor.setPageSize(categoryResponsePage.getSize());
//        cursor.setPageNumber(categoryResponsePage.getNumber());
//        cursor.setTotalElements(categoryResponsePage.getTotalElements());

        return ResultHelper.cursor(categoryResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    // valid diyerek validation anatosyon veriyoruz bunu kontrol et diyoruz. Notnull u kontrol ediyoruz
    public ResultData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        // eğer olmayan bir ıd yi update etmek istersek hata veriyoruz daha sonra manager ı niçinde yaptık
        //this.categoryService.get(categoryUpdateRequest.getId());
        Category updateCategory = this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updateCategory);
        CategoryResponse categoryResponse = this.modelMapper.forResponse().map(updateCategory, CategoryResponse.class);
        return ResultHelper.success(categoryResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.categoryService.delete(id);
        return ResultHelper.ok();
    }

}

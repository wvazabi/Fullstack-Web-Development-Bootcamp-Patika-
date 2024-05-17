package com.engenes.ecommerce.api;

import com.engenes.ecommerce.business.abstracts.ICategoryService;
import com.engenes.ecommerce.business.abstracts.IProductService;
import com.engenes.ecommerce.business.abstracts.ISupplierService;
import com.engenes.ecommerce.core.config.modelMaper.IModelMapperService;
import com.engenes.ecommerce.core.result.ResultData;
import com.engenes.ecommerce.core.utilies.ResultHelper;
import com.engenes.ecommerce.dto.request.category.CategorySaveRequest;
import com.engenes.ecommerce.dto.request.product.ProductSaveRequest;
import com.engenes.ecommerce.dto.response.category.CategoryResponse;
import com.engenes.ecommerce.dto.response.product.ProductResponse;
import com.engenes.ecommerce.entities.Category;
import com.engenes.ecommerce.entities.Product;
import com.engenes.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

        private final IProductService productService;
        private final IModelMapperService modelMapper;
        private final ICategoryService categoryService;
        private final ISupplierService supplierService;


    public ProductController(
         IProductService productService,
         IModelMapperService modelMapper,
         ICategoryService categoryService,
         ISupplierService supplierService) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    // valid diyerek validation anatosyon veriyoruz bunu kontrol et diyoruz. Notnull u kontrol ediyoruz
    public ResultData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest) {
        Product saveProduct = this.modelMapper.forRequest().map(productSaveRequest, Product.class);
        //category ve supplier bilgisini save producta maple ama maplerken manuel set ediyoruz
        Category category = this.categoryService.get(productSaveRequest.getCategoryId());
        saveProduct.setCategory(category);

        Supplier supplier = this.supplierService.get(productSaveRequest.getSupplierId());
        saveProduct.setSupplier(supplier);

        this.productService.save(saveProduct);
        ProductResponse productResponse = this.modelMapper.forResponse().map(saveProduct, ProductResponse.class);
        return ResultHelper.created(productResponse);
    }

}

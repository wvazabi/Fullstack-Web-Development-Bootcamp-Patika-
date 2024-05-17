package com.engenes.ecommerce.api;

import com.engenes.ecommerce.business.abstracts.ISupplierService;
import com.engenes.ecommerce.core.config.modelMaper.IModelMapperService;
import com.engenes.ecommerce.core.result.ResultData;
import com.engenes.ecommerce.core.utilies.ResultHelper;
import com.engenes.ecommerce.dto.request.category.CategorySaveRequest;
import com.engenes.ecommerce.dto.request.supplier.SupplierSaveRequest;
import com.engenes.ecommerce.dto.request.supplier.SupplierUpdateRequest;
import com.engenes.ecommerce.dto.response.category.CategoryResponse;
import com.engenes.ecommerce.dto.response.supplier.SupplierResponse;
import com.engenes.ecommerce.entities.Category;
import com.engenes.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {
    // dependency injection
    private final ISupplierService supplierService;
    private final IModelMapperService modelMapper;


    public SupplierController(ISupplierService supplierService, IModelMapperService modelMapper) {
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    // valid diyerek validation anatosyon veriyoruz bunu kontrol et diyoruz. Notnull u kontrol ediyoruz
    public ResultData<SupplierResponse > save(@Valid @RequestBody SupplierSaveRequest supplierSaveRequest) {
        Supplier saveSupplier = this.modelMapper.forRequest().map(supplierSaveRequest, Supplier.class);
        this.supplierService.save(saveSupplier);

         return ResultHelper.created(this.modelMapper.forResponse().map(saveSupplier,SupplierResponse.class));


    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    // valid diyerek validation anatosyon veriyoruz bunu kontrol et diyoruz. Notnull u kontrol ediyoruz
    public ResultData<SupplierResponse> update(@Valid @RequestBody SupplierUpdateRequest supplierUpdateRequest) {
        // eğer olmayan bir ıd yi update etmek istersek hata veriyoruz daha sonra manager ı niçinde yaptık
        //this.categoryService.get(categoryUpdateRequest.getId());
        Supplier updateSupplier = this.modelMapper.forRequest().map(supplierUpdateRequest, Supplier.class);
        this.supplierService.update(updateSupplier);
        SupplierResponse supplierResponse = this.modelMapper.forResponse().map(updateSupplier, SupplierResponse.class);
        // buda web serviste güncelleme olduktan sonra güncellenen datayı döndürüyoruz 
        return ResultHelper.success(supplierResponse);

    }

}

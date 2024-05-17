package com.engenes.ecommerce.business.concretes;

import com.engenes.ecommerce.business.abstracts.IProductService;
import com.engenes.ecommerce.core.exception.NotFoundException;
import com.engenes.ecommerce.core.utilies.Msg;
import com.engenes.ecommerce.dao.ProductRepo;
import com.engenes.ecommerce.entities.Category;
import com.engenes.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements IProductService {

    private final ProductRepo productRepo;

    public ProductManager(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product save(Product product) {
        return this.productRepo.save(product);
    }

    @Override
    public Product get(int id) {
        return this.productRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Product> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        //peagination ı kendi otomatik yaparım diyor bu şekilde
        return this.productRepo.findAll(pageable);
    }

    @Override
    public Product update(Product product) {
        this.get(product.getId());
        return this.productRepo.save(product);
    }

    @Override
    public boolean delete(int id) {
        Product product = this.get(id);
        this.productRepo.delete(product);
        return true;
    }
}

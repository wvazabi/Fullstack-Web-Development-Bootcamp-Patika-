package com.engenes.ecommerce.business.abstracts;

import com.engenes.ecommerce.entities.Product;
import com.engenes.ecommerce.entities.Supplier;
import org.springframework.data.domain.Page;

public interface IProductService {

    Product save(Product product);

    Product get(int id);

    Page<Product> cursor(int page, int pageSize);

    Product update(Product product);

    boolean delete(int id);


}

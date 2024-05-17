package com.engenes.ecommerce.business.abstracts;

import com.engenes.ecommerce.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    //Category response requesti burda yapmıyoruz çünkü onlar API ile ilgili bizim n katmnalı mvc mimarimize etkisi
    // yok kendi içimize onlar karışmıyorlar
    Category save(Category category);
    Category get(int id);
    Page<Category> cursor(int page, int pageSize);

    //pagenation kodlamada cursor deniliyormuş2


}

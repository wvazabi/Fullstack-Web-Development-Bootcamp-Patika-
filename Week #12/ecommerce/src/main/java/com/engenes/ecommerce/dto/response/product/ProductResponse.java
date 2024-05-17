package com.engenes.ecommerce.dto.response.product;

import com.engenes.ecommerce.entities.Category;
import com.engenes.ecommerce.entities.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String name;
    private double prc;
    private int stock;
    // supplier category nesnesi göndermiyoruz id gönderiyoruz
    private int supplierId;
    private int categoryId;
}

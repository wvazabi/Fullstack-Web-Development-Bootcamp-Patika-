package com.engenes.ecommerce.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {
    // id yi kaldırıyoruz
    private String name;
    private double prc;
    private int stock;
    // supplier category nesnesi göndermiyoruz id gönderiyoruz
    private int supplierId;
    private int categoryId;
}
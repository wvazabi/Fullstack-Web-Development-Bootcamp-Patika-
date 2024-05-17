package com.engenes.ecommerce.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateRequest {
    //integer degere validasyon atıyoruz
    @Positive(message = "ID value must be positive")
    private int id;
    @NotNull(message = "Category has not bu null")
    private String name;

}

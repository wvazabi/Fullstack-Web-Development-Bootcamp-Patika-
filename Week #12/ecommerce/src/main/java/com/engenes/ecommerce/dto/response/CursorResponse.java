package com.engenes.ecommerce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursorResponse<T> {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    //servisteki kontent kısmı category reponse product response ne gelirse
    // generic olarak onu liste halinde göndericek
    private List<T> items;
}

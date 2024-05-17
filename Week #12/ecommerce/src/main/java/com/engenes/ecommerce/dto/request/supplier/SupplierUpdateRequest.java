package com.engenes.ecommerce.dto.request.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierUpdateRequest {

    // save requeste id olmaz update de olur

    @Positive
    private int id;
    @NotNull
    private String companyName;

    private String contactName;

    private String address;

    @Email
    private String contactMail;
}

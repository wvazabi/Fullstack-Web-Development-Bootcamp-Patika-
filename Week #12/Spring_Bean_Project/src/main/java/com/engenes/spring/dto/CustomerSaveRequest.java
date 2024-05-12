package com.engenes.spring.dto;

import com.engenes.spring.entities.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    @NotNull
    private String customerName;
    @Email
    private String customerMail;
    private Customer.GENDER customerGender;

}

package com.engenes.spring.dto;

import com.engenes.spring.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    private String customerName;
    private String customerMail;
    private Customer.GENDER customerGender;

}

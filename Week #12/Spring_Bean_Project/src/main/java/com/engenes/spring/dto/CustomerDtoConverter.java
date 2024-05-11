package com.engenes.spring.dto;

import com.engenes.spring.entities.Customer;

public class CustomerDtoConverter {

    public CustomerDto convertDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getCustomerId());
        customerDto.setName(customer.getCustomerName());
        customerDto.setMail(customer.getCustomerMail());

        return customerDto; 
    }
}

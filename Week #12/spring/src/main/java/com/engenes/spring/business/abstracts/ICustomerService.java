package com.engenes.spring.business.abstracts;

import com.engenes.spring.Customer;

public interface ICustomerService {
    Customer save(Customer customer);
    Customer getById(int id);
    Customer update(Customer customer);
    void delete(Customer customer);
}

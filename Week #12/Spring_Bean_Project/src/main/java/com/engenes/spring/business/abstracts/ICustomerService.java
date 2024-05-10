package com.engenes.spring.business.abstracts;

import com.engenes.spring.entities.Customer;

import java.util.List;

public interface ICustomerService {

    Customer save(Customer customer);
    Customer getById(int id);
    Customer update(Customer customer);
    void delete(int id);

    //CRUD işlemler

    List<Customer> findAll();
}

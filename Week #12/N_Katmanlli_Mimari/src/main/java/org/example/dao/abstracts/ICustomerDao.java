package org.example.dao.abstracts;

import org.example.entities.Customer;

import java.util.List;

public interface ICustomerDao {
    void save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void deleteById(int id);

    List<Customer> findAll();
}

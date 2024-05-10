package com.engenes.spring.business.concretes;

import com.engenes.spring.business.abstracts.ICustomerService;
import com.engenes.spring.dao.ICustomerRepo;
import com.engenes.spring.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerService {

    //Injection IoC ye dev ediyoruz o hallediyor
    @Autowired
    private ICustomerRepo customerRepo;

    public CustomerManager() {
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer getById(int id) {
        return this.customerRepo.findById(id).orElseThrow();
    }


    @Override
    public Customer update(Customer customer) {
        if (customer.getCustomerId() == 0) {
            throw new RuntimeException("Please enter valid id");
        }
        return this.customerRepo.save(customer);
    }

    @Override
    public void delete(int id) {
        Customer customer = this.getById(id);
        this.customerRepo.delete(customer);

    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }
}

package com.engenes.spring.business.concretes;

import com.engenes.spring.Customer;
import com.engenes.spring.business.abstracts.ICustomerService;
import com.engenes.spring.dao.ICustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {

    private final ICustomerRepo iCustomerRepo;

    public CustomerManager(ICustomerRepo iCustomerRepo) {
        this.iCustomerRepo = iCustomerRepo;
    }

    @Override
    public Customer save(Customer customer) {
        return this.iCustomerRepo.save(customer);
    }

    @Override
    public Customer getById(int id) {
        return this.iCustomerRepo.findById(id).orElseThrow();
    }


    @Override
    public Customer update(Customer customer) {
        if (customer.getCustomerId() == 0) {
            throw new RuntimeException("Please enter valid id");
        }
        return this.iCustomerRepo.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.iCustomerRepo.delete(customer);

    }
}

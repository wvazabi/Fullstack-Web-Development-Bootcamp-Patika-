package org.example.business.concretes;

import org.example.business.abstracts.ICustomerService;
import org.example.dao.concretes.CustometDao;
import org.example.entities.Customer;

import java.util.List;

public class CustomerManager implements ICustomerService {

    private final CustometDao custometDao;

    //Dependency Injection
    public CustomerManager(CustometDao custometDao) {
        this.custometDao = custometDao;
    }


    @Override
    public void save(Customer customer) {
        // custoemr kontrolü mail konrtrolü
        // veri tabanı işlemleri daoda işin yönetimi business
        Customer checkMailCustomer = this.custometDao.findByMail(customer.getCustomerMail());

        if (checkMailCustomer != null) {
            throw new RuntimeException(customer.getCustomerMail() + "Bu mail adresi daha önce eklenmiş");
        }

        this.custometDao.save(customer);

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}

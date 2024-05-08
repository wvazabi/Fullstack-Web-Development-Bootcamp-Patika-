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

        return this.custometDao.findById(id);
    }

    @Override
    public void update(Customer customer) {

        Customer checkMailCustomer = this.custometDao.findByMail(customer.getCustomerMail());

        //bu sayede başka bir kullanıcının mailini başka bir kullanıcıya atayamazlar
        if (checkMailCustomer != null && checkMailCustomer.getCustomerId() != customer.getCustomerId()) {
            throw new RuntimeException(customer.getCustomerMail() + "Bu mail adresi daha önce eklenmiş");
        }

        this.custometDao.update(customer);

    }

    @Override
    public void deleteById(int id) {

        this.custometDao.delete(this.findById(id));
    }

    @Override
    public List<Customer> findAll() {
        return custometDao.findAll();
    }
}

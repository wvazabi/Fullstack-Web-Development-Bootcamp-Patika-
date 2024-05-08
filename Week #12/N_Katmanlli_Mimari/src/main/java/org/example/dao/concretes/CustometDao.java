package org.example.dao.concretes;

import org.example.core.HibernateSession;
import org.example.dao.abstracts.ICustomerDao;
import org.example.entities.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustometDao implements ICustomerDao {

    // final olarak oluşturmak zorunda olsun
    private final Session session;

    public CustometDao() {
        this.session = HibernateSession.getSession();
    }

    @Override
    public void save(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        //session transaction oluşturuluyor
        this.session.getTransaction().commit();

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

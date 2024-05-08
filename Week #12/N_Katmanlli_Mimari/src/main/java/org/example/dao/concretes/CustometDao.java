package org.example.dao.concretes;

import org.example.core.HibernateSession;
import org.example.dao.abstracts.ICustomerDao;
import org.example.entities.Customer;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

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
        return this.session.get(Customer.class,1);

    }

    @Override
    public void update(Customer customer) {
        this.session.beginTransaction();
        // persist o idli veri varsa update yoksa insert ediyor
        this.session.persist(customer);
        //session transaction oluşturuluyor
        this.session.getTransaction().commit();

    }

    @Override
    public void delete(Customer customer) {
        this.session.beginTransaction();
        //remove metodu obje aldığı için parametrede customer id alamadık
        this.session.remove(customer);
        this.session.getTransaction().commit();

    }

    @Override
    public List<Customer> findAll() {

        //List<Customer>  customers = this.session.createSelectionQuery("FROM Customer",Customer.class).getResultList();

        return this.session
                .createSelectionQuery("FROM Customer",Customer.class)
                .getResultList();
    }

    @Override
    public Customer findByMail(String mail) {
        SelectionQuery<Customer> query = this.session.
                createSelectionQuery("FROM Customer WHERE mail = :mail", Customer.class);
        // sorgudaki maili metod içersindeki parametre ile değiştir
        query.setParameter("mail",mail);
        // eğer veri varsa customer objesi yoska null değeri
        return query.getSingleResultOrNull();
    }

    //yeni metoda ihtiyaç duyduğumuzda interfacede tanımlayıp işlemleri yaparız
}

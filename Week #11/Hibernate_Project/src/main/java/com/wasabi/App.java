package com.wasabi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {

        //Hibernate'de JPA yi sessionlar üzerinden yönetiyoruz JPA'da
        // entity managerdan yönetiyorduk

        // Hibernate Configuration
        // Persistence xml yerine
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                //kullanmak istediğimiz entityleri burda ekliyoruz
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
        // Build Hibernate Session Factory
        Session session = factory.openSession();
        // Open a session

        //TODO Create - Read - Update - Delete CRUD
        session.beginTransaction();
        try {
            // Session başlatma ve transaction başlatma


            // Veritabanı işlemleri burada gerçekleştirilir

            Customer customer = new Customer();

            //
//            customer.setCustomerName("Test");
//            customer.setCustomerGender(Customer.GENDER.FEMALE);
//            customer.setCustomerOnDate(LocalDate.now());
//            customer.setCustomerMail("test@patika.dev");
//
//
//            session.persist(customer);

            //session.remove(customer);

//            customer = session.get(Customer.class,1);
//            System.out.println(customer.toString());

            //farklı yolla veri çekme
            //customer = session.byId(Customer.class).getReference(1);

            List<Customer> customers = session
                    .createSelectionQuery("FROM Customer", Customer.class)
                    .getResultList();

            System.out.println(customers.toString());
            // Transaction'ı commit etme
            session.getTransaction().commit();
        } catch (Exception e) {
            // Hata durumunda transaction'ı geri al ve exception yazdır
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Session'ı kapat
                session.close();
        }

    }


}

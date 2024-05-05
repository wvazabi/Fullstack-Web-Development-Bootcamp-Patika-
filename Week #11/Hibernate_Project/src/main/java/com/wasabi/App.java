package com.wasabi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        //Hibernate'de JPA yi sessionlar üzerinden yönetiyoruz JPA'da
        // entity managerdan yönetiyorduk

        // Hibernate Configuration
        // Persistence xml yerine
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        // Build Hibernate Session Factory
        Session session = factory.openSession();
        // Open a session

        session.beginTransaction();
        try {
            // Session başlatma ve transaction başlatma


            // Veritabanı işlemleri burada gerçekleştirilir

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

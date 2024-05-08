package org.example.core;

import org.example.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {

    // org hibernate den gelen bir session, sibgelton olarak tanımlıyoeuz hafızada sürekli
    // session oluşturma isteiğini ortadan kaldırmış olduk
    public static Session session = null;
    public static Session getSession() {
        //hiç session oluşturulmamışssa oluşturur

        if (session == null) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    //entitiyleri ekliyoruz
                    .addAnnotatedClass(Customer.class)
                    //session factory de build oluyor
                    .buildSessionFactory();

            session = factory.openSession();
        }

        return session;
    }
}

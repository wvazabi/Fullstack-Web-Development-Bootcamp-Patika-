package com.wasabi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library_management");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        //entityManager.getTransaction().begin();

        //hata alınmazsa commitleme işlemi yapar
       // entityManager.getTransaction().commit();


//        transaction.begin();
//
////        Publisher publisher = new Publisher();
////
////        publisher.setName("Can Yayınları");
////        publisher.setEstYear(1989);
////        publisher.setAddress("Nişantası/İstanbul");
////
////        entityManager.persist(publisher);
//
//        transaction.commit();

    }
}
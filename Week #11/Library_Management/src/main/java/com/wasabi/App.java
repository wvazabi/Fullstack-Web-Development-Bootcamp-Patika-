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


        transaction.begin();

        //Publisher
        Publisher publisher = new Publisher();
        publisher.setName("Can Yayınları");
        publisher.setAddress("Nişantası/İstanbul");
        publisher.setEstablishmentYear(1996);
        entityManager.persist(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Kutup Ayısı");
        publisher2.setEstablishmentYear(1996);
        publisher2.setAddress("Maltepe/İstanbul");
        entityManager.persist(publisher2);

        //Book
        Book book = new Book();
        book.setName("Harry Potter");
        book.setStock(100);
        book.setPublicationYear(2002);
        entityManager.persist(book);

        Book book2 = new Book();
        book2.setName("Star Wars");
        book2.setPublicationYear(1994);
        book2.setStock(28);
        entityManager.persist(book2);

        //Author

        Author author = new Author();
        author.setName("");





        transaction.commit();

    }
}
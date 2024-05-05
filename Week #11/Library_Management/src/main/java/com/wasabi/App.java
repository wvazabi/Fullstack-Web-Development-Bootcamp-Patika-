package com.wasabi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static <categories> void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library_management");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        //entityManager.getTransaction().begin();

        //hata alınmazsa commitleme işlemi yapar
       // entityManager.getTransaction().commit();


   //     transaction.begin();
//
//        //Publisher
//        Publisher publisher = new Publisher();
//        publisher.setName("Can Yayınları");
//        publisher.setAddress("Nişantası/İstanbul");
//        publisher.setEstablishmentYear(1996);
//        entityManager.persist(publisher);
//
//        Publisher publisher2 = new Publisher();
//        publisher2.setName("Kutup Ayısı");
//        publisher2.setEstablishmentYear(1996);
//        publisher2.setAddress("Maltepe/İstanbul");
//        entityManager.persist(publisher2);
//
//        //Category
//        Category category = new Category();
//        category.setName("Fiction");
//        category.setDescription("Fiction Stories");
//        entityManager.persist(category);
//
//        //Author
//        Author author = new Author();
//        author.setName("George Lucas");
//        author.setCountry("USA");
//        author.setBirtDate(LocalDate.of(1994, 5, 14));
//        entityManager.persist(author);
//
//        Author author2 = new Author();
//        author2.setName("J. K. Rowling");
//        author2.setCountry("UK");
//        author2.setBirtDate(LocalDate.of(1965,7,31));
//        entityManager.persist(author2);
//
//        //Book
//        Book book = new Book();
//        book.setName("Harry Potter");
//        book.setStock(100);
//        book.setPublicationYear(2002);
//        book.setAuthor(author2);
//        book.setPublisher(publisher);
//        List<Category> categories = new ArrayList<>();
//        categories.add(category);
//        book.setCategories(categories);
//        entityManager.persist(book);
//
//        Book book3 = new Book();
//        book3.setName("Hobbit");
//        book3.setStock(1300);
//        book3.setPublicationYear(2002);
//        book3.setAuthor(author2);
//        book3.setPublisher(publisher);
//        List<Category> categories5 = new ArrayList<>();
//        categories5.add(category);
//        book.setCategories(categories5);
//        entityManager.persist(book3);
//
//        Book book2 = new Book();
//        book2.setName("Star Wars");
//        book2.setPublicationYear(1994);
//        book2.setStock(28);
//        book2.setAuthor(author);
//        book2.setPublisher(publisher2);
//        List<Category> categories2 = new ArrayList<>();
//        categories2.add(category);
//        book2.setCategories(categories2);
//        entityManager.persist(book2);
//
//
//        //Book Borrowing
//        BookBorrowing bb = new BookBorrowing();
//        bb.setName("Enes Kaya");
//        bb.setBorrowingDate(LocalDate.of(2024,1,31));
//        bb.setReturnDate(LocalDate.of(2024,4,21));
//        bb.setBook(book);
//        entityManager.persist(bb);
//
//
//
//
//        transaction.commit();
//
//        transaction.begin();
//
//        Author author = entityManager.find(Author.class,2);
//        for(Book book : author.getBookList()) {
//            System.out.println(book.getName());
//        }
//        transaction.commit();

        

    }
}
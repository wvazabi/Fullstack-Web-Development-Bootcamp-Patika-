package dev.wasabiTech;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

//        transaction.begin();
//        Customer customer = new Customer();
//
//        customer.setCustomerName("Enes");
//        customer.setCustomerMail("enes@gmail.com");
//        customer.setCustomerOnDate(LocalDate.now());
//        customer.setCustomerGender(Customer.GENDER.MALE);
//        entityManager.persist(customer);
//        transaction.commit();

//        Customer customer = entityManager.find(Customer.class,1);
//
//        transaction.begin();
//
//        customer.setCustomerName("Update Test");

//        System.out.println(customer.toString());
//        entityManager.persist(customer);
//        entityManager.remove(customer);
//        transaction.commit();

        transaction.begin();
/*
        //supplier
        Supplier supplier = new Supplier();
        supplier.setMail("apple@cargo.com");
        supplier.setAddress("maltepe/istanbul");
        supplier.setCompany("apple");
        supplier.setContact("Apple USA");
        entityManager.persist(supplier);

        //category
        Category category = new Category();
        category.setName("Phones");
        entityManager.persist(category);

        //code
        Code code = new Code();
        code.setGroup("3111");
        code.setSerial("234324");
        entityManager.persist(code);

        //product
        Product product = new Product();
        product.setName("Apple Iphoe 16");
        product.setPrice(22434.0);
        product.setStock(100);
        product.setCode(code);
        product.setSupplier(supplier);
        product.setCategory(category);

        entityManager.persist(product);
        System.out.println(product.toString());

*/
/*
        Colors blue  = new Colors("blue");
        Colors red = new Colors("red");
        Colors yellow = new Colors("yellow");

        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(yellow);

        Product product = entityManager.find(Product.class,1);

        List<Colors> colorsList = new ArrayList<>();
        colorsList.add(blue);
        colorsList.add(yellow);
        colorsList.add(red);

        product.setColorList(colorsList);

        entityManager.persist(product);

         */

        //Cascade ilişkisel arası türleri belirliyor
        // one to one ilişkilerde persist mantıklı
        //code entity managerda persist yapılmadan oluşuyor cascade i tanımlandığı için product olasa  yeter
        Code code = new Code();
        code.setGroup("11");
        code.setSerial("9999");

        Product product = new Product();
        product.setName("Apple Macbook Pro");
        product.setPrice(22434.0);
        product.setStock(100);
        product.setCode(code);
        product.setSupplier(entityManager.find(Supplier.class,1));
        product.setCategory(entityManager.find(Category.class,1));

        entityManager.persist(product);

        transaction.commit();






    }
}
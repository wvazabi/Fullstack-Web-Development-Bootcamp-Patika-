package dev.wasabiTech;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
//        Code code = new Code();
//        code.setGroup("11");
//        code.setSerial("9999");
//
//        Product product = new Product();
//        product.setName("Apple Macbook Pro");
//        product.setPrice(22434.0);
//        product.setStock(100);
//        product.setCode(code);
//        product.setSupplier(entityManager.find(Supplier.class,1));
//        product.setCategory(entityManager.find(Category.class,1));
//
//        entityManager.persist(product);
//
//        transaction.commit();


// Tüm ürünleri çekme örneği
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> productList = query.getResultList();

// ID'si 1 olan kategoriyi çekme örneği
        TypedQuery<Category> categoryQuery = entityManager.createQuery("SELECT c FROM Category c WHERE c.id = 1", Category.class);
        Category singleCategory = categoryQuery.getSingleResult();
//        JPQL ve Parametre Kullanımı:
//        java
//        Copy code
// Belirli bir fiyattan düşük olan ürünleri çekme örneği
//        TypedQuery<Product> priceQuery = entityManager.createQuery("SELECT p FROM Product p WHERE p.price < :maxPrice", Product.class);
//        priceQuery.setParameter("maxPrice", 100.0);
//        List<Product> affordableProducts = priceQuery.getResultList();
//
//        // belirli bir özelliği çekmek için veri tipini yazıyporuz
//        TypedQuery<String> prodQuery = entityManager.createQuery("SELECT p.name FROM Product p WHERE p.price < :maxPrice", String.class);
//        List<String> productNameList = prodQuery.getResultList();
//
//        for(String str : productNameList) {
//            System.out.println(str);
//        }



    // -  DTO data transfer objectler yaratılıyor ORM lerde
        TypedQuery<CheapProduct> prodQuery2 = entityManager.createQuery("SELECT NEW CheapProduct(p.id,p.name,p.price) FROM Product p where p.price > 10", CheapProduct.class);
        List<CheapProduct> cheapProductList = prodQuery2.getResultList();


        for(CheapProduct cp : cheapProductList) {
            System.out.println(cp.toString());
        }

        // Veritabanından ürün sayısını çekme
        TypedQuery<Long> countQuery = entityManager.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
        Long productCount = countQuery.getSingleResult();

// Veritabanından en yüksek fiyatlı ürünü çekme
        TypedQuery<Product> maxPriceQuery = entityManager.createQuery(
                "SELECT p FROM Product p ORDER BY p.price DESC", Product.class);
        maxPriceQuery.setMaxResults(1);
        Product maxPricedProduct = maxPriceQuery.getSingleResult();

// Kategori bazında ürün sayılarını listeleyebilme
        TypedQuery<Object[]> categoryProductCountQuery = entityManager.createQuery(
                "SELECT c.name, COUNT(p) FROM Product p JOIN p.category c GROUP BY c.name", Object[].class);
        List<Object[]> categoryProductCountList = categoryProductCountQuery.getResultList();

// Like sorgusu ile belirli bir örneğe uyan ürünleri çekme
        TypedQuery<Product> likeQuery = entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.name LIKE 'BR%'", Product.class);
        List<Product> likeResultList = likeQuery.getResultList();




//        TypedQuery<Product> prodQuery3 = entityManager.createQuery("SELECT p FROM Product p WHERE p.category.id IN (:cat1, :cat2)", Product.class);
//
//        prodQuery3.setParameter("cat1",1);
//        prodQuery3.setParameter("cat2",2);

        TypedQuery<Product> prodQuery3 = entityManager.createQuery("SELECT p FROM Product p WHERE p.category.id IN :catIdList", Product.class);

        List<Integer> catList = Arrays.asList(2,4);
        prodQuery3.setParameter("catIdList", catList);

        List<Product> productList2 = prodQuery3.getResultList();


        TypedQuery<Product> cheapProductsQuery = entityManager.createNamedQuery("Product.findCheapProducts", Product.class);
        cheapProductsQuery.setParameter("price", 20.0);
        List<Product> cheapProducts = cheapProductsQuery.getResultList();


        transaction.commit();

    }
}
package org.example.view;

import org.example.business.concretes.CustomerManager;
import org.example.dao.concretes.CustometDao;
import org.example.entities.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new CustometDao());

        Customer customer = new Customer();

//        // aynı veri eklenmiyor dao ya gitmeden busnes hata
//        customer.setCustomerName("Enes Kaya");
//        customer.setCustomerGender(Customer.GENDER.FEMALE);
//        customer.setCustomerMail("nilay@ecz.com");
//        customer.setCustomerOnDate(LocalDate.now());
//
////        customer.setCustomerName("Enes Kaya");
////        customer.setCustomerGender(Customer.GENDER.MALE);
////        customer.setCustomerMail("eness@eng.com");
////        customer.setCustomerOnDate(LocalDate.now());
//
//
//        customerManager.save(customer);

//        Customer firstCustomer = customerManager.findById(2);
//        System.out.println(firstCustomer.toString());
//        customerManager.deleteById(2);

//        Customer customer2 = customerManager.findById(4);
//
//        System.out.println(customer2.toString());
//
//        customer2.setCustomerName("Nilay Kaya");
//        customer2.setCustomerMail("eness@eng.com");
//        customerManager.update(customer2);

        List<Customer> customers = customerManager.findAll();

        for (Customer customerElement : customers) {

            System.out.println(customerElement);
        }


    }
}
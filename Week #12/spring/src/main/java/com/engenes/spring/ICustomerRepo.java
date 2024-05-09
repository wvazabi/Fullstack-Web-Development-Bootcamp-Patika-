package com.engenes.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CRUD Repository, JPA Repository
@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Integer> {

    Customer findBycustomerMail (String mail);

}

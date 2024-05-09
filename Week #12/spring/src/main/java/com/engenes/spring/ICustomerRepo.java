package com.engenes.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//CRUD Repository, JPA Repository
@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Integer> {

    Customer findBycustomerMail (String mail);

    //Customer query
    @Query("FROM Customer as c WHERE c.customerGender = :gender")
     List<Customer> queryByGender(@Param("gender") Customer.GENDER gender);


}

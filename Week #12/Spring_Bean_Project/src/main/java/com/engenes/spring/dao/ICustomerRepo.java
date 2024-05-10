package com.engenes.spring.dao;

import com.engenes.spring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//identitysi integer olan dao sınıfı
@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Integer> {
}

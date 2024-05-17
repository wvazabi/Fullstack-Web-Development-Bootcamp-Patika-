package com.engenes.ecommerce.dao;

import com.engenes.ecommerce.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Entity ve veri tipi tanımlıyoeuz
@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Integer> {
}

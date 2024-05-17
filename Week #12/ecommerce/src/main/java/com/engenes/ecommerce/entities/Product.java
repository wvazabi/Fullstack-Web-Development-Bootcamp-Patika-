package com.engenes.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "serial")
    private int id;

    @Column(name = "procuct_name")
    private String name;

    @Column(name = "product_price")
    private double prc;

    @Column(name = "product_stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "product_supplier_id", referencedColumnName = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id")
    private Category category;



}

package com.engenes.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // column def serial veriyoruz bu sayede auto increment yapıyor
    @Column(name = "category_id", columnDefinition = "serial")
    private int id;

    @Column(name = "category_name")
    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}

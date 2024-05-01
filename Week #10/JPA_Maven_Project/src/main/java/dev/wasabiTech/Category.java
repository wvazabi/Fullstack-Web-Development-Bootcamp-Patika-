package dev.wasabiTech;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int  id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}

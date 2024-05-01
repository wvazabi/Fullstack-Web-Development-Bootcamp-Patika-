package dev.wasabiTech;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "serial")
    private int id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_prc")
    private Double price;

    @Column(name = "product_stock", nullable = false)
    private int stock;

    @OneToOne
    @JoinColumn(name = "product_code_id", referencedColumnName = "code_id")
    private Code code;

    // Diğer özellikler ve getter/setter metotları


    public Product() {
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

    public java.lang.Double getPrice() {
        return price;
    }

    public void setPrice(java.lang.Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", stock=" + stock +
                ", code=" + code +
                '}';
    }
}
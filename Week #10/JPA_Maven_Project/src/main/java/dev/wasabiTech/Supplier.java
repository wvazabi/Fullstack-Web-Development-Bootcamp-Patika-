package dev.wasabiTech;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", columnDefinition = "serial")
    private Integer id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "supplier_mail", unique = true)
    private String mail;

    @Column(name = "supplier_contact")
    private String contact;
//
    // burda tam tersini ekliyoruz birdan fazla product olacağı için product tipinde list
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    // Diğer özellikler ve getter/setter metotları


    public Supplier() {
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getAddress() {
        return address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.String getCompany() {
        return company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }

    public java.lang.String getMail() {
        return mail;
    }

    public void setMail(java.lang.String mail) {
        this.mail = mail;
    }

    public java.lang.String getContact() {
        return contact;
    }

    public void setContact(java.lang.String contact) {
        this.contact = contact;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Supplier{" +
                "id=" + id +
                ", address=" + address +
                ", company=" + company +
                ", mail=" + mail +
                ", contact=" + contact +
                '}';
    }
}

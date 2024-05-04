package com.wasabi;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "publisher_name", length = 100, nullable = false)
    private String name;

    @Column(name = "publisher_establishment_year")
    private int estYear;


    @Column(name = "publisher_address", unique = true, nullable = false)
    private String address;

    public Publisher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstYear() {
        return estYear;
    }

    public void setEstYear(int estYear) {
        this.estYear = estYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", estYear=" + estYear +
                ", address='" + address + '\'' +
                '}';
    }
}

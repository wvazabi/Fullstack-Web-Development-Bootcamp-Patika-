package com.engenes.spring;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
// Lombok Features
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Data hepsini getiriyor ama @NoArgsConstructor
//@AllArgsConstructor bunlarıda yazmak lazım

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false)
    private Integer customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    //Todo cutomer mail adresi benzersz olmalı

    @Column(name = "customer_mail", unique = true, nullable = false)
    private String customerMail;


    @Column(name = "customer_on_date")
    @Temporal(TemporalType.DATE)
    private LocalDate customerOnDate;



    //TODO enum oldugunu ve tipinin string oldugunu söylüyoz
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender", length = 10)
    private GENDER customerGender;

    public enum GENDER {
        FEMALE,
        MALE
    }


}
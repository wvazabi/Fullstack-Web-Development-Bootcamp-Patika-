package com.wasabi;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
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

    public Customer() {
    }

    public LocalDate getCustomerOnDate() {
        return customerOnDate;
    }

    public void setCustomerOnDate(LocalDate customerOnDate) {
        this.customerOnDate = customerOnDate;
    }

    public GENDER getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(GENDER customerGender) {
        this.customerGender = customerGender;
    }

    public java.lang.Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(java.lang.Integer customerId) {
        this.customerId = customerId;
    }

    public java.lang.String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }

    public java.lang.String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(java.lang.String customerMail) {
        this.customerMail = customerMail;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName=" + customerName +
                ", customerMail=" + customerMail +
                ", customerOnDate=" + customerOnDate +
                ", customerGender=" + customerGender +
                '}';
    }
// Getter ve setter metotları

    // Diğer özellikler de eklenebilir.
}

package com.engenes.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    // nelerrin gösterileeğinin ayrımını yapıyoruz
    //çıktı olarak bunlar yazıcaak
    // Customer -> Cutomer DTO

    //Model mapper için isimlerndirme entity ye göre benzer olmalı
    private int id;
    private String name;
    private String mail;
}

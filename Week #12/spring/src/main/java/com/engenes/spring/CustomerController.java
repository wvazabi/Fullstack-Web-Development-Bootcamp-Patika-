package com.engenes.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//bunu dedikten sonra responde body dememize gerek kalmıyor
@RestController
@RequestMapping("/customer")
public class CustomerController  {
    @GetMapping("/")
    public String get() {
         return "Customer get metodu çalıştı";
    }
}

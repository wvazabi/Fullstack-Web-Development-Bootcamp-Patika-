package com.engenes.spring;

import org.springframework.web.bind.annotation.*;

//bunu dedikten sonra responde body dememize gerek kalmıyor
@RestController
@RequestMapping("/customer")
public class CustomerController  {
    @GetMapping("/")
    public String get() {
         return "Customer get metodu çalıştı";
    }

//    @PostMapping("/save")
//    public String save(@RequestBody String data) {
//        return "Customer Save Metodu Çalıştı " + data;
//    }


}

package com.engenes.spring.api;

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

    /*
    IoC uygulaması 3 farklı yöntemle uygulanabilir

    Constructor

    private final ICustomerRepo customerRepo;
    private final ICustomerService customerService;

    public CustomerController2(ICustomerRepo iCustomerRepo, ICustomerService iCustomerService) {
        this.customerRepo = iCustomerRepo;
        this.customerService = iCustomerService;
    }




    Setter
    @Autowired
    public setCustomerController2(ICustomerRepo iCustomerRepo, ICustomerService iCustomerService) {
        this.customerRepo = iCustomerRepo;
        this.customerService = iCustomerService;
    }


    Field
    @Autowired
    private ICustomerRepo customerRepo;
     */


}

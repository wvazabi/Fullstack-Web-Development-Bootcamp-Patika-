package com.engenes.spring;

//Normalde vies presentationdan dao controllera
// geçilmez arada business service olur bu deneme için

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController2  {
    private final ICustomerRepo iCustomerRepo;

    public CustomerController2(ICustomerRepo iCustomerRepo) {
        this.iCustomerRepo = iCustomerRepo;
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") int id) {
        return this.iCustomerRepo.findById(id).orElseThrow();
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return this.iCustomerRepo.save(customer);
    }

    @GetMapping("/find-all")
    public List<Customer> findAll(){
        return this.iCustomerRepo.findAll();
    }

    @GetMapping("/mail/{mail}")
    public Customer findByMail(@PathVariable("mail") String mail) {
        return this.iCustomerRepo.findBycustomerMail(mail);
    }

    //@GetMapping("/mail/{mail}/{gender}")
}

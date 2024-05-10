package com.engenes.spring.api;

//Normalde vies presentationdan dao controllera
// geçilmez arada business service olur bu deneme için

import com.engenes.spring.Customer;
import com.engenes.spring.business.abstracts.ICustomerService;
import com.engenes.spring.dao.ICustomerRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController2  {


    private final ICustomerRepo customerRepo;
    private final ICustomerService customerService;

    public CustomerController2(ICustomerRepo iCustomerRepo, ICustomerService iCustomerService) {
        this.customerRepo = iCustomerRepo;
        this.customerService = iCustomerService;
    }

    // customer servisten alıyor kontrol yapıyor
    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") int id) {
        return this.customerService.getById(id);
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return this.customerRepo.save(customer);
    }

    @GetMapping("/find-all")
    public List<Customer> findAll(){
        return this.customerRepo.findAll();
    }

    @GetMapping("/mail/{mail}")
    public Customer findByMail(@PathVariable("mail") String mail) {
        return this.customerRepo.findBycustomerMail(mail);
    }

    //@GetMapping("/mail/{mail}/{gender}")
}

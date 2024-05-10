package com.engenes.spring.api;

import com.engenes.spring.business.abstracts.ICustomerService;
import com.engenes.spring.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    //verileri listelemeye ihtiyacımız var
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll(){
        return this.customerService.findAll();
    }

}

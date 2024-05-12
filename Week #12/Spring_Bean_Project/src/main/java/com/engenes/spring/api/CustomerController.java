package com.engenes.spring.api;

import com.engenes.spring.business.abstracts.ICustomerService;
import com.engenes.spring.dto.CustomerDto;
import com.engenes.spring.dto.CustomerDtoConverter;
import com.engenes.spring.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerDtoConverter converter;

    //verileri listelemeye ihtiyacımız var
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll(){
        return this.customerService.findAll();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody Customer customer) {
        return this.customerService.update(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") int id) {
        this.customerService.delete(id);

    }

    // getById
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto findById(@PathVariable("id") int id) {
        Customer customer = this.customerService.getById(id);
        CustomerDto customerDto = this.converter.convertDto(customer);
        return customerDto;
    }



}

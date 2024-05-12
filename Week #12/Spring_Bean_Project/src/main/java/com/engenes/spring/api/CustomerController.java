package com.engenes.spring.api;

import com.engenes.spring.business.abstracts.ICustomerService;
import com.engenes.spring.dto.CustomerDto;
//import com.engenes.spring.dto.CustomerDtoConverter;
import com.engenes.spring.dto.CustomerSaveRequest;
import com.engenes.spring.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

//    @Autowired
//    private CustomerDtoConverter converter;

    @Autowired
    private ModelMapper modelMapper;

    //verileri listelemeye ihtiyacımız var
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> findAll(){
        // custom mapleme
//        List<Customer> customerList =  this.customerService.findAll();
//        List<CustomerDto> customerDtoList = customerList.stream().map(
//                customer -> this.converter.convertDto(customer)
//        ).collect(Collectors.toList());

        /*
        daha kısa yazmak için
        return this.customerService.findAll();
        List<CustomerDto> customerDtoList = customerList.stream().map(
                customer -> this.converter.convertDto(customer)
        ).collect(Collectors.toList());
         */
        //model mapper için tekrardan converter gibi bir nesne üretmeden yapmaya yarıyor

        List<Customer> customerList =  this.customerService.findAll();
        List<CustomerDto> customerDtoList = customerList.stream().map(
                customer -> this.modelMapper.map(customer,CustomerDto.class)
        ).collect(Collectors.toList());

        return customerDtoList;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }
    // TODO Response, Request DTO Kullanılması
//    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest) {
//        Customer newCustomer = this.modelMapper.map(customerSaveRequest,  Customer.class);
//        // oluşturma date bilgisini api kullanıcısından almamalıyız kendimiz atıyoruz
//        newCustomer.setCustomerOnDate(LocalDate.now());
//        return this.customerService.save(newCustomer);
//    }

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
//        //
//        Customer customer = this.customerService.getById(id);
//        CustomerDto customerDto = this.converter.convertDto(customer);
        // tek satırda yazmak için
        // return this.converter.convertDto(this.customerService.getById(id));

        //return customerDto;


        //model mapperlı yöntem

        return this.modelMapper.map(this.customerService.getById(id),CustomerDto.class);
    }



}

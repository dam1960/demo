package com.dam.sample.controller;

import com.dam.sample.domain.Customer;
import com.dam.sample.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/find-by-id/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id).get();
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/find-all-by-last-name/{lastName}")
    public List<Customer> findByLastName(@PathVariable String lastName) {
        return customerService.findAllByLastName(lastName);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/find-all")
    public Iterable<Customer> findAll() {
        return customerService.findAll();
    }
}

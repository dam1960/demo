package com.dam.sample.service;

import com.dam.sample.domain.Customer;
import com.dam.sample.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAllByLastName(String lastName) {
        return customerRepository.findAllByLastName(lastName);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
}

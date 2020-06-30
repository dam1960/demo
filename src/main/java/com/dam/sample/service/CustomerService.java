package com.dam.sample.service;

import com.dam.sample.dao.CustomerDao;
import com.dam.sample.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer findById(long id) {
        return customerDao.findById(id);
    }

    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    public List<Customer> findByLastName(String lastName) {
        return customerDao.findByLastName(lastName);
    }
}

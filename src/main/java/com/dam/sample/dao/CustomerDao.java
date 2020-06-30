package com.dam.sample.dao;

import com.dam.sample.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerDao extends CrudRepository<Customer, Long> {
    Customer findById(long id);

    Customer save(Customer customer);

    List<Customer> findByLastName(String lastName);
}

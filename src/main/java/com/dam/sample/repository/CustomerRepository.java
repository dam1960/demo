package com.dam.sample.repository;

import com.dam.sample.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAllByLastName(String lastName);
}

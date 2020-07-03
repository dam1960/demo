package com.dam.sample.service;

import com.dam.sample.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void findById() {
        Customer customer = customerService.findById(1);
        assertEquals("David", customer.getFirstName());
    }

    @Test
    void save() {
        Customer customer = new Customer();
        customer.setFirstName("Barney");
        customer.setLastName("Gumble");
        customer.setEmail("bgumble@gmail.com");

        Customer customer1 = customerService.save(customer);
        assertNotNull(customer1);
    }

    @Test
    void findByLastName() {
        List<Customer> customers = customerService.findByLastName("Simpson");
        assertEquals(2, customers.size());
    }

    @Test
    void delete() {
        customerService.delete(1L);
        assertNull(customerService.findById(1L));
    }
}

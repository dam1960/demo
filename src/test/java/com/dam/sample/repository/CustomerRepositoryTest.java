package com.dam.sample.repository;

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
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findById() {
        Customer customer = customerRepository.findById(1);
        assertEquals(1, customer.getId());
    }

    @Test
    void saveInsert() {
        Customer customer = new Customer();
        customer.setFirstName("Barney");
        customer.setLastName("Gumble");
        customer.setEmail("bgumble@gmail.com");

        Customer customer1 = customerRepository.save(customer);
        assertNotNull(customer1);
        assertEquals(5L, customer1.getId());
    }

    @Test
    void saveUpdate() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("gonzo@gmail.com");

        Customer customer1 = customerRepository.save(customer);
        assertNotNull(customer1);
        assertEquals("gonzo@gmail.com", customer1.getEmail());
    }

    @Test
    void findByLastName() {
        List<Customer> customers = customerRepository.findByLastName("Simpson");
        assertEquals(2, customers.size());
    }

    @Test
    void deleteById() {
        customerRepository.deleteById(1L);
        assertNull(customerRepository.findById(1L));
    }
}

package com.dam.sample.service;

import com.dam.sample.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void findById() {
        Optional<Customer> customer = customerService.findById(1);
        assertEquals("David", customer.get().getFirstName());
        assertEquals("Miranda", customer.get().getLastName());
    }

    @Test
    void save() {
        Customer customer = new Customer();
        customer.setFirstName("Barney");
        customer.setLastName("Gumble");
        customer.setEmail("bgumble@gmail.com");

        Customer customer1 = customerService.save(customer);
        assertNotNull(customer1);
        assertEquals(5L, customer1.getId());
    }

    @Test
    void findByLastName() {
        List<Customer> customers = customerService.findAllByLastName("Simpson");
        assertEquals(2, customers.size());
    }

    @Test
    void delete() {
        customerService.deleteById(1L);
        assertTrue(customerService.findById(1L).isEmpty());
    }

    @Test
    void findAll() {
        Iterable<Customer> customers = customerService.findAll();
        assertNotNull(customers);
    }
}

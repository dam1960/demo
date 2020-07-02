package com.dam.sample.dao;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    void findById() {
        Customer customer = customerDao.findById(1);
        assertEquals(1, customer.getId());
    }

    @Test
    void saveInsert() {
        Customer customer = new Customer();
        customer.setFirstName("Barney");
        customer.setLastName("Gumble");
        customer.setEmail("bgumble@gmail.com");

        Customer customer1 = customerDao.save(customer);
        assertNotNull(customer1);
    }

    @Test
    void saveUpdate() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("gonzo@gmail.com");

        Customer customer1 = customerDao.save(customer);
        assertNotNull(customer1);
        assertEquals("gonzo@gmail.com", customer1.getEmail());
    }

    @Test
    void findByLastName() {
        List<Customer> customers = customerDao.findByLastName("Simpson");
        assertEquals(2, customers.size());
    }
}

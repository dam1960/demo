package com.dam.sample.controller;

import com.dam.sample.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestClientException;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    private final String url = "http://localhost:";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findById() {
        Customer customer = this.restTemplate.getForObject(url + port + "/customer/find-by-id/1", Customer.class);
        assertNotNull(customer);
    }

    @Test
    public void save() {
        Customer customer = new Customer();
        customer.setFirstName("Barney");
        customer.setLastName("Gumble");
        customer.setEmail("bgumble@gmail.com");

        Customer customer1 = this.restTemplate.postForObject(url + port + "/customer/save", customer, Customer.class);
        assertNotNull(customer1);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void findByLastName() {
        List<Customer> customers =  this.restTemplate.getForObject(url + port + "/customer/find-all-by-last-name/Simpson", List.class);
        assertNotNull(customers);
    }

    @Test
    public void delete() throws RestClientException {
        this.restTemplate.delete(url + port + "/customer/delete-by-id/1L");
    }

    @Test
    public void findAll() {
        Iterable customers = this.restTemplate.getForObject(url + port + "/customer/find-all", Iterable.class);
        assertNotNull(customers);
    }
}

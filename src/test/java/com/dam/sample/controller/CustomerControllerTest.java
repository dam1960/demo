package com.dam.sample.controller;

import com.dam.sample.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestClientException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    private String url = "http://localhost:";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findById() {
        assertThat(this.restTemplate.getForObject(url + port + "/customer/find-by-id/1", Customer.class));
    }

    @Test
    public void save() {
        Customer customer = new Customer();
        customer.setFirstName("Barney");
        customer.setLastName("Gumble");
        customer.setEmail("bgumble@gmail.com");

        assertThat(this.restTemplate.postForObject(url + port + "/customer/save", customer, Customer.class));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void findByLastName() {
        assertThat(this.restTemplate.getForObject(url + port + "/customer/find-by-last-name/Simpson", List.class));
    }

    @Test
    public void delete() throws RestClientException {
        this.restTemplate.delete(url + port + "/customer/delete-by-id/1L");
    }

    @Test
    public void findAll() {
        assertThat(this.restTemplate.getForObject(url + port + "/customer/find-all", Iterable.class));
    }
}

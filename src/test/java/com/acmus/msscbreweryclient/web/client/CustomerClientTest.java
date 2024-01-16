package com.acmus.msscbreweryclient.web.client;

import com.acmus.msscbreweryclient.web.model.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }


    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Galaxy").build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer() throws JsonProcessingException {
        CustomerDto customerDto = CustomerDto.builder().name("Sam").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void testDeleteCustomerById() {
        CustomerDto customerDto = CustomerDto.builder()
                .id(UUID.randomUUID()).name("Sami").build();

        client.deleteCustomerById(customerDto.getId());
    }
}

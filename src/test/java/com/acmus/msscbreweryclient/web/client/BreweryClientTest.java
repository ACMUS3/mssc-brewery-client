package com.acmus.msscbreweryclient.web.client;

import com.acmus.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }


    @Test
    void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder()
                .id(UUID.randomUUID()).beerName("Galaxy-888").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder()
                .id(UUID.randomUUID()).beerName("Galaxy-888").build();

        client.updateBeer(UUID.randomUUID(),beerDto);

    }

    @Test
    void deleteBeerById() {
        BeerDto beerDto = BeerDto.builder()
                .id(UUID.randomUUID()).beerName("Galaxy-888").build();

        client.deleteBeerById(beerDto.getId());
    }
}

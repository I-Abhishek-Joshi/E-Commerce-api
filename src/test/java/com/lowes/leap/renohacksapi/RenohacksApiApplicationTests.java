package com.lowes.leap.renohacksapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RenohacksApiApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnOkForGetAllProductsRequest() {
		ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/products", String.class);
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

	}
}
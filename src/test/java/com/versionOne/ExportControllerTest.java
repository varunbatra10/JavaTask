package com.versionOne;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExportControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getFreeCards() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/export/free-cards").toString(), String.class);
		String expectedJson = "[\r\n" + "    \"1wBUO-DZHZH-gjg9J-4VXr4-rLgtp\",\r\n"
				+ "    \"79emc-SAIDI-5GZsF-n3Sqz-7sLJb\",\r\n" + "    \"8PLMI-qZWQu-LuXfz-khxc7-Y8Q9j\",\r\n"
				+ "    \"99rXG-1Ynwp-ahF4J-btmQ6-wg6d3\",\r\n" + "    \"IsOne-INVQ5-53Hgx-idDeq-ETAbW\",\r\n"
				+ "    \"YZkdP-LuRyn-pM6S2-gZwKP-0OK3o\",\r\n" + "    \"oMmcJ-pd1N8-qp2Of-dLsow-PDCkW\",\r\n"
				+ "    \"rnarn-v81q4-ItpUT-ewYUu-6PGwc\",\r\n" + "    \"ukBy1-rliJm-tMvvk-jRLtI-Z4byL\"\r\n" + "]";
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expectedJson, response.getBody(), false);

	}

	@Test
	public void getProductiveEmployees() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/export/productive-employees").toString(), String.class);
		String expectedJson = "[\r\n" + "    [\r\n" + "        \"Rick Sanchez\",\r\n"
				+ "        \"Head Scientist\",\r\n" + "        \"65RrK-NRzLZ-pJLZN-Chp3q-tovmA\"\r\n" + "    ],\r\n"
				+ "    [\r\n" + "        \"Summer Greav\",\r\n" + "        \"Secretary\",\r\n"
				+ "        \"Onm25-YwwpH-RPFg4-ik3lu-ZeNy8\"\r\n" + "    ]\r\n" + "]";
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expectedJson, response.getBody(), false);

	}

	@Test
	public void getTowns() throws Exception {
		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/export/towns").toString(), String.class);
		String expectedJson = "[[\"Bangalore\",11882666,2.0E7],[\"Mexico City\",12041284,6502323.0],[\"New York\",11563790,5001024.0],[\"Sofia\",2001050,102859.0],[\"Dublin\",1214666,100000.0],[\"Tokyo\",27634593,20000.0],[\"Delhi\",12398421,10312.0],[\"Sidney\",4283102,10000.0]]";
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expectedJson, response.getBody(), false);

	}

	@Test
	public void getTopBranches() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/export/top-branches").toString(), String.class);
		String expectedJson = "[[\"Bangalore Central Branch\",\"Bangalore\",2.0E7],[\"Mexico Main Branch\",\"Mexico City\",6502323.0],[\"Central Park Branch\",\"New York\",5001024.0],[\"Headquarters\",\"Sofia\",102859.0],[\"Dublin Central Branch\",\"Dublin\",100000.0],[\"Tokyo Main Branch\",\"Tokyo\",20000.0],[\"Delhi Western Branch\",\"Delhi\",10312.0],[\"Sidney Central Branch\",\"Sidney\",10000.0]]";
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expectedJson, response.getBody(), false);

	}

}

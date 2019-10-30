package com.dtcc.app.App;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.AppApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=AppApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class SecurityControllerTest {
	
	@Autowired
	private TestRestTemplate template;

	@Test 
	public void testGet() {
		String url = "/security-details/{id}";
		String result = template.getForObject(url, String.class, 1);
		System.out.println(result);
	}
	@Test
	public void testPost() {
		Security stock = new Security();
		stock.setPrice(9.99);
		stock.setSymbol("FOO");
		stock.setName("FOO BAR FOO");
		stock.setSecurity_id("S11120");
		String url = "/security-details";
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Security> entity = new HttpEntity<Security>(stock, headers);
		ResponseEntity<String> response = template.postForEntity(url, entity, String.class);
		System.out.println(response);
	}

}
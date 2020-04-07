package com.epam.dev_ecommerce.resttest;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTest {
	
	RequestSpecification request;
	
	String BaseURI="http://10.71.8.199:8081/ecommerce";
	
	Response response;
	
	@BeforeClass
	public void init() {
		
		RestAssured.baseURI=BaseURI;
		
		request=RestAssured.given();
		
	} 

}

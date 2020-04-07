package com.epam.dev_ecommerce.cucumber_tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.epam.dev_ecommerce.Exceptions.DriverNotFoundException;
import com.epam.dev_ecommerce.dbTest.RetrieveTest;
import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.uitest.UITest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class End2End extends UITest{
	
	RequestSpecification request;
	Response response;
	List<Category> actualCategories;
	
	@Given("RestApi Base URL")
	public void rest_Base_URL() {
		request=null;
		response=null;
		RestAssured.baseURI="http://10.71.8.199:8081/ecommerce";
		request=RestAssured.given();
	   
	}
	
	@When("Perform GET method on Base path {string}")
	public void perform_GET_method_on_Base_path(String path) {
		response=request.get("/categories");
	}

	@Then("check status code is {int}")
	public void check_status_code_is(Integer statuscode) {
	    response.then().assertThat().statusCode(statuscode);
	}

	@Then("check Response has list of categories")
	public void check_Response_has_list_of_categories() {
		
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<Category>> ref1 = new TypeReference<List<Category>>() { };
		actualCategories=mapper.convertValue(request.get("/categories").body().as(List.class),ref1);
		
		
		
	}

	@Then("check Rest categories are same as categories in UI")
	public void check_Rest_categories_are_same_as_categories_in_UI() throws DriverNotFoundException {
		this.openBrowser();
		checkCategories(actualCategories);
	   
	}

	@Then("check Rest categories are same as categories in DB")
	public void check_Rest_categories_are_same_as_categories_in_DB() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		RetrieveTest db=new RetrieveTest();
		db.connectToDb();
	    db.checkCategories(actualCategories);
	   
	}

}

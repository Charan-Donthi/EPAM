package com.epam.dev_ecommerce.cucumber_tests;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.dev_ecommerce.objects.ProductDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;



public class CucmberRestTest {
	
	RequestSpecification request;
	Response response;
	
	
	@BeforeClass
	@Given("Rest Base URL")
	public void rest_Base_URL() {
		request=null;
		response=null;
		RestAssured.baseURI="http://10.71.8.199:8081/ecommerce";
		request=RestAssured.given();
	   
	}
	
	
    @Test
	@When("perform GET method on  Base Path \\/product\\/{int}")
	public void perform_GET_method_on_Base_Path_product(Integer productId) {
		response=request.get("/product/"+productId);
	}


    @Test
	@Then("check response contains product details with no null values")
	public void check_response_contains_product_details_with_no_null_values(int productId,int subCategoryId,String productName,float productPrice,int productQuantity)  {
    	
    	response
		.then()
		.assertThat()
		.body("productId", is(productId))
		.and()
		.body("subCategoryId", is(subCategoryId) )
		.and()
		.body("productName", is(productName))
		.and()
		.body("productPrice",is(productPrice))
		.and()
		.body("productQuantity", is(productQuantity));
		
	}
	
    @Test
	@When("perform GET method on Base Path \\/subcategory\\/{int}\\/products")
	public void perform_GET_method_on_Base_Path_ecommerce_subcategory_products(Integer subCategoryId) {
		response=request.get("/subcategory/"+subCategoryId+"/products");
	}

    @Test
	@Then("check response {int}")
	public void check_response(Integer expectedStatusCode) {
		response.then().assertThat().statusCode(expectedStatusCode);
	}

	
	@Then("check response contains {string}")
	public void check_response_contains()  {

    	
	}

	
	@Test
	@Then("each product contains product details with no null values")
	public void each_product_contains_product_details_with_no_null_values() {
		ProductDetails product1=new ProductDetails();
    	product1.setProductId(16).setSubCategoryId(1).setProductName("Corona").setProductQuantity(100).setProductPrice(900000.0);
    	
    	ProductDetails product2=new ProductDetails();
    	product2.setProductId(10).setSubCategoryId(1).setProductName("Onida 2").setProductQuantity(10).setProductPrice(2000.0);
    
    	ObjectMapper mapper=new ObjectMapper();
    	
    	LinkedHashMap<Object,Object> link1=mapper.convertValue(product1, LinkedHashMap.class);
    	LinkedHashMap<Object,Object> link2=mapper.convertValue(product2, LinkedHashMap.class);
    	
    	List<LinkedHashMap<Object,Object>> list=new ArrayList<LinkedHashMap<Object,Object>>();
    	
    	list.add(link1);
    	
    	list.add(link2);
    	
    	List<LinkedHashMap> l=request.get("/subcategory/"+1+"/products").body().as(List.class);
    	
    	System.out.println(l);
    	System.out.println(l.removeAll(list));
    	System.out.println(l);
    	
    	System.out.println(request.get("/subcategory/"+1+"/products").body().asString());
	   
	}
	
	
	


}

package com.epam.dev_ecommerce.tests;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.dev_ecommerce.dataproviders.Data;
import com.epam.dev_ecommerce.dataproviders.Data.ProductDetails;
import com.epam.dev_ecommerce.dataproviders.Data.ProductSerializer;
import com.epam.dev_ecommerce.objects.Category;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EcommerceRestTesting {
	
	RequestSpecification request;
	
	String BaseURI="http://10.71.8.199:8081/ecommerce";
	
	Response response;
	
	@BeforeClass
	public void init() {
		
		RestAssured.baseURI=BaseURI;
		
		request=RestAssured.given();
		
	}
	
	@Test
	public void categoriesResponse() {	
		request.get("/categories").then().assertThat().statusCode(200);	
	
	}
	
	@Test(dependsOnMethods= {"categoriesResponse"})
	public void checkcontentType() {
		request.get("/categories").then().assertThat().header("content-type", "application/json");
	}
	
	

	@Test(dependsOnMethods= {"categoriesResponse"},dataProviderClass=Data.class,dataProvider="categoryListToCheck")
	public void checkPresenceOfCategory(String categoryName){
		
		ObjectMapper mapper=new ObjectMapper();
		
		List<LinkedHashMap<Object,Object>> categoryList=new ArrayList<LinkedHashMap<Object,Object>>();
		
		
		TypeReference<LinkedHashMap<Object,Object>> ref = new TypeReference<LinkedHashMap<Object,Object>>() { };
		LinkedHashMap<Object,Object> map=mapper.convertValue(new Category().setCategoryId(1).setCategoryName("Electronics"), ref);
		
		
		categoryList.add(mapper.convertValue(new Category().setCategoryId(2).setCategoryName("Fashion"), ref));
		
		categoryList.add(mapper.convertValue(new Category().setCategoryId(13).setCategoryName("ABCDE"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(3).setCategoryName("Books and Audible"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(4).setCategoryName("Home Appliancesss"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(5).setCategoryName("Electronicss"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(6).setCategoryName("TUUV"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(8).setCategoryName("TV22"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(11).setCategoryName("ABCDE"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(12).setCategoryName("ABCDE"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(14).setCategoryName("ABCDE"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(1).setCategoryName("Electronics"), ref));
		categoryList.add(mapper.convertValue(new Category().setCategoryId(7).setCategoryName("TUUV"), ref));
		
		assertTrue(request.get("/categories").body().as(List.class).containsAll(categoryList));
		
		
	}
	
	
	@Test(dataProviderClass=Data.class,dataProvider="subcategoryListToCheck")
	public void subcategoriesResponse(Data.data d){
		assertEquals(request.get("/category/"+d.categoryId+"/subcategories").getStatusCode(),200);	
	
	}
	
	
	@SuppressWarnings("rawtypes")
	@Test(dataProviderClass=Data.class,dataProvider="subcategoryListToCheck")
	public void checkPresenceOfSubCategory(Data.data d){
		assertTrue(((ArrayList)request.get("/category/"+d.categoryId+"/subcategories").path("subCategoryName")).contains(d.subcategoryName));
	}
	
	@Test(dataProviderClass=Data.class,dataProvider="productsToCheck")
	public void productsResponse(int subcategoryId){
		request.get("/subcategory/"+subcategoryId+"/products").then().assertThat().statusCode(200);	
	
	}
	
	@SuppressWarnings("rawtypes")
	@Test(dataProviderClass=Data.class,dataProvider="productsListToCheck")
	public void checkProduct(int subCategoryId,String productName){
		assertTrue(((ArrayList)request.get("/subcategory/"+subCategoryId+"/products").path("productName")).contains(productName));
	}
	
	@Test
	public void cartResponse(){
		request.get("/cart").then().assertThat().statusCode(200);	
	
	}
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void checkProductInCart(String productName){
		
		assertTrue(((ArrayList)request.get("/cart").path("productName")).contains(productName));
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void checkForEmptyCart(){
		assertTrue(((ArrayList)request.get("/cart").path("")).isEmpty());
	}
	
	@Test
	public void postNewCategory(String categoryName) {
		JSONObject json=new JSONObject();
		json.put("categoryName", categoryName);
		RestAssured.given().header("content-type", "application/json").body(json.toJSONString()).post("/category/add-new-category").then().assertThat().statusCode(201);
	}
	
	@Test
	public void postNewSubCategory(int categoryId,String subCategoryName) {
		JSONObject json=new JSONObject();
		json.put("categoryId",categoryId);
		json.put("subCategoryName", subCategoryName);
		RestAssured.given().header("content-type", "application/json").body(json.toJSONString()).post("/subcategory/add-new-subcategory").then().assertThat().statusCode(201);
		
	}
	
	@Test(dataProviderClass=Data.class,dataProvider="dataToAddProductThroughPost")
	public void postNewProduct(ProductDetails productdetails) throws JsonProcessingException {
		ProductSerializer productserializer=new ProductSerializer(ProductDetails.class);
		ObjectMapper mapper=new ObjectMapper();
		RestAssured.given().header("content-type", "application/json").body(mapper.writeValueAsString(productdetails)).post("/product/add-new-product").then().assertThat().statusCode(201);
		
	}


}

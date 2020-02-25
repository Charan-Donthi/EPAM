package restAssured.RestAssuredExample;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestingRestServices {
	
	RequestSpecification httpRequest;
	
  @BeforeClass
  public void BuildingSpecifications() {
	  httpRequest=RestAssured.given();
  }
  
  
	
  @Test(dataProvider="dataProviderForValidationOfStatusCode")
  public void verifyHttpStatusCode(String URL,int expectedStatus) {

	  Response response=httpRequest.get(URL);
	  int actualStatus=response.statusCode();
	  assertEquals(actualStatus,expectedStatus);  
  }
  
  @DataProvider
  public Object[][] dataProviderForValidationOfStatusCode(){ 
	  return new Object[][] {
		  {"https://jsonplaceholder.typicode.com/users",200},
		  {"https://petstore.swagger.io/#/pet",200}
		  };
  }
  
  
  
  
  
  
  @Test(dataProvider="dataProviderForVerifyingPresenceOfHeaders",dependsOnMethods="verifyHttpStatusCode")
  public void VerifyPresenseOfHeadersInHttpResponse(String URL,String header) {
	  Response response=httpRequest.get(URL);
	  assertTrue(response.getHeaders().hasHeaderWithName(header));
  }
  
  @DataProvider
  public Object[][] dataProviderForVerifyingPresenceOfHeaders(){ 
	  return new Object[][] {
		  {"https://jsonplaceholder.typicode.com/users","Content-Type"},
		  {"https://petstore.swagger.io/#/pet","Content-Type"}
		  };
  }
  
  
  
  
  
  
  @Test(dataProvider="dataProviderForValidatingHeaders",dependsOnMethods="VerifyPresenseOfHeadersInHttpResponse")
  public void verifyHttpResponseHeader(String URL,String contentType) {

	  Response response=httpRequest.get(URL);
	  assertEquals(response.getHeader("Content-Type"),contentType);

  }
  
  @DataProvider
  public Object[][] dataProviderForValidatingHeaders(){ 
	  return new Object[][] {
		  {"https://jsonplaceholder.typicode.com/users","application/json; charset=utf-8"},
		  {"https://petstore.swagger.io/#/pet","application/json; charset=utf-8"}
		  };
  }
  
  
  
  

  @Test(dataProvider="dataProviderForVerifyingHttpResponse",dependsOnMethods="verifyHttpStatusCode")
  public void verifyHttpResponseBody(String URL,String key) {
	  Response response=httpRequest.get(URL);
	  assertEquals(response.jsonPath().getList(key).size(),10);
  }
	  
  
  @DataProvider
  public Object[][] dataProviderForVerifyingHttpResponse() {
	  return new Object[][] {
		  {"https://jsonplaceholder.typicode.com/users","id"},
	  };
  }
  
  
  
  @Test(dataProvider="dataProviderForVerifyingHttpResponseForPost",dependsOnMethods="verifyHttpStatusCode")
  public void verifyResponseStatusCodeForPost(String URL,String header,String headerValue) {
	  
	  JSONObject jsonParams=new JSONObject();
	  jsonParams.put("id", 11);
	  httpRequest.header(header, headerValue);
	  httpRequest.body(jsonParams.toString());
	  Response response = httpRequest.post(URL);
	  assertEquals(response.getStatusCode(),201);
  }
  
  
  
  @DataProvider
  public Object[][] dataProviderForVerifyingHttpResponseForPost() {
	  return new Object[][] {
		  {"https://jsonplaceholder.typicode.com/users","Content-Type","application/json"},
		  {"https://petstore.swagger.io/#/pet","Content-Type","application/json"},
	  };
  }
  
  
  
}

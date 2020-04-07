package com.epam.dev_ecommerce.resttest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.objects.ProductDeserializer;
import com.epam.dev_ecommerce.objects.ProductDetails;
import com.epam.dev_ecommerce.objects.SubCategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.restassured.response.Response;

import static org.testng.Assert.assertTrue;


public class RestPostTest extends RestTest{
	
		
		@Test
		public void checkPostCategory(Category category) {
			
			response=this.postCategory(category);
			
			Category actualCategory=response.body().as(Category.class);
			
			assertTrue(response.statusCode()==201 && actualCategory.getCategoryName().equals(category.getCategoryName()));
			
		}
	
	
		
		
		public Response postCategory(Category category) {
			ObjectMapper mapper=new ObjectMapper();
			
			response=request
					.header("content-type", "application/json")
					.body(mapper.convertValue(category, JSONObject.class))
					.post("/category/add-new-category");
			
			return response;
					
		}
	
	
	@Test
	public void checkPostSubCategory() {
		
		SubCategory subcategory=new SubCategory().setSubCategoryId(13).setCategoryId(2).setSubCategoryName("QQQ");
		
		response=this.postSubCategory(subcategory);
		
		SubCategory actualSubCategory=response.body().as(SubCategory.class);
		
		assertTrue(response.statusCode()==201 && actualSubCategory.equals(subcategory));
		
	}


	
	
	public Response postSubCategory(SubCategory subcategory) {
		ObjectMapper mapper=new ObjectMapper();
		
		response=request
				.header("content-type", "application/json")
				.body(mapper.convertValue(subcategory, JSONObject.class))
				.post("/subcategory/add-new-subcategory");
		
		return response;
				
	}
	
	
	
	@Test
	public void checkPostProduct() {
		
		ProductDetails product=new ProductDetails().setSubCategoryId(1).setProductId(21).setProductName("QQQ");
		
		response=this.postProduct(product);
		
		ProductDetails actualProduct=response.body().as(ProductDetails.class);
		
		assertTrue(response.statusCode()==201 && actualProduct.equals(product));
		
	}


	
	
	public Response postProduct(ProductDetails product) {
		ObjectMapper mapper=new ObjectMapper();
		
		response=request
				.header("content-type", "application/json")
				.body(mapper.convertValue(product, JSONObject.class))
				.post("/product/add-new-product");
		
		return response;
				
	}
	
	
	
	@Test
	public void checkPostedProductInCart(ProductDetails product) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		SimpleModule module = new SimpleModule();
		module.addDeserializer(ProductDetails.class, new ProductDeserializer());
		mapper.registerModule(module);

		response=this.postProductInCart(product);
		
		ProductDetails actualproduct=mapper.convertValue(response.body().as(JSONObject.class), ProductDetails.class);
		
		assertTrue(actualproduct.equalsByCart(product));
		
	}
	
	public Response postProductInCart(ProductDetails product) {
		
		return request
			.post("/cart/"+product.getProductId()+"/"+product.getProductQuantity());
		
		
	}
	
}

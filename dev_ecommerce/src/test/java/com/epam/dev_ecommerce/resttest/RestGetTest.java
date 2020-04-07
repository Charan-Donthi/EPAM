package com.epam.dev_ecommerce.resttest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.objects.ProductDeserializer;
import com.epam.dev_ecommerce.objects.ProductDetails;
import com.epam.dev_ecommerce.objects.SubCategory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;


public class RestGetTest extends RestTest{


	
	
	@Test
	public void checkCategories(List<Category> expected) throws JsonParseException, JsonMappingException, IOException {
		
		List<Category> list = getCategories();
		
		assertTrue(list.containsAll(expected) && list.size()==expected.size());
		
		
	}

	public List<Category> getCategories() {
		ObjectMapper mapper=new ObjectMapper();
		
		TypeReference<List<Category>> ref1 = new TypeReference<List<Category>>() { };
		
		List<Category> list=mapper.convertValue(request.get("/categories").body().as(List.class),ref1);
		return list;
	}
	
	@Test
	public void checkCategoriesOfParticularCategory(List<SubCategory> expected) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		TypeReference<List<SubCategory>> ref1 = new TypeReference<List<SubCategory>>() { };
		
		List<SubCategory> list=mapper.convertValue(request.get("/category/1/subcategories").body().as(List.class),ref1);
		
		assertTrue(list.containsAll(expected) && list.size()==expected.size());
		
	}
	
	
	@Test
	public void checkProductsOfParticularSubCategory(SubCategory subcategory,List<ProductDetails> expected) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		TypeReference<List<ProductDetails>> ref1 = new TypeReference<List<ProductDetails>>() { };
		
		List<ProductDetails> list=mapper.convertValue(request.get("/subcategory/"+subcategory.getSubCategoryId()+"/products").body().as(List.class),ref1);
		
		assertTrue(list.equals(expected));

		
	}
	
	@Test
	public void checkProductDetails(ProductDetails expected) {
		
		ProductDetails actual=request.get("/product/1").body().as(ProductDetails.class);
		
		assertTrue(actual.equals(expected));
	}
	
	
	@Test
	public void checkCartProducts(List<ProductDetails> expected) {
		
		List<ProductDetails> expectedproducts=expected.stream().map(p->p.setSubCategoryId(0)).collect(Collectors.toList());
		
		ObjectMapper mapper=new ObjectMapper();
		
		SimpleModule module = new SimpleModule();
		module.addDeserializer(ProductDetails.class, new ProductDeserializer());
		mapper.registerModule(module);
		
		TypeReference<List<ProductDetails>> ref1 = new TypeReference<List<ProductDetails>>() { };
		
		List<ProductDetails> list=mapper.convertValue(request.get("/cart").body().as(List.class),ref1);
		
		
		assertTrue(list.equals(expectedproducts));
		
		
		
	}
	
	@Test
	public void checkCartTotalPrice(double totalPrice) {
		assertTrue(totalPrice==Double.parseDouble(request.get("/cart/totalprice").body().asString()));
	}
	
	
	
}

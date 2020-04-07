package com.epam.dev_ecommerce.dbTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.objects.ProductDetails;
import com.epam.dev_ecommerce.objects.SubCategory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RetrieveTest extends DbTest{
	
	@Test
	public void checkCategories(List<Category> expectedCategories) throws SQLException {
		
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<HashMap<String,Object>>> ref = new TypeReference<List<HashMap<String,Object>>>() { };
		List<HashMap<String,Object>> list=mapper.convertValue(expectedCategories, ref);
		
		List<HashMap<String,Object>> actualCategories=getCategories();
		
		assertTrue(actualCategories.containsAll(list) && actualCategories.size()==list.size());
		
	}

	
	@Test
	public void checkParticularCategory(Category expectedCategory) throws SQLException {
		ObjectMapper mapper=new ObjectMapper();
		assertThat(getCategories(),hasItem(mapper.convertValue(expectedCategory,HashMap.class)));
	}
	
	
	private List<HashMap<String,Object>> getCategories() throws SQLException {
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("SELECT * FROM ecommerce1.category");
		List<HashMap<String,Object>> actualCategories=new ArrayList<HashMap<String,Object>>();
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<HashMap<String,Object>> ref = new TypeReference<HashMap<String,Object>>() { };
		while(result.next()) {
			actualCategories.add(mapper.convertValue(new Category().setCategoryId(result.getInt("category_id")).setCategoryName(result.getString("category_name")),ref));
		}
		return actualCategories;
	}
	
	
	
	
	
	
	@Test
	public void checkSubCategories(List<SubCategory> expectedsubcategories) throws SQLException {
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<HashMap<String,Object>>> ref = new TypeReference<List<HashMap<String,Object>>>() { };
		List<HashMap<String,Object>> list=mapper.convertValue(expectedsubcategories, ref);
		
		List<HashMap<String,Object>> actualSubCategories=getSubCategories();
		
		assertTrue(actualSubCategories.containsAll(list)  && actualSubCategories.size()==list.size());
		
		
	}
	
	@Test
	public void checkCategoriesUnderParticularCategory(Category category,List<SubCategory> expectedSubCategories) throws SQLException {
		
		List<HashMap<String,Object>> actualSubCategories=getSubCategories().stream().filter(sub->sub.get("categoryId").equals(new Integer(category.getCategoryId()))).collect(Collectors.toList());
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<HashMap<String,Object>>> ref = new TypeReference<List<HashMap<String,Object>>>() { };
		List<HashMap<String,Object>> list=mapper.convertValue(expectedSubCategories, ref);
		
		assertTrue(actualSubCategories.containsAll(list) && actualSubCategories.size()==list.size());
		
		
	}
	
	
	@Test
	public void checkParticularSubCategoryUnderParticularCategory(Category category,SubCategory subCategory) throws SQLException {
		List<HashMap<String,Object>> actualSubCategories=getSubCategories().stream().filter(sub->sub.get("categoryId").equals(new Integer(category.getCategoryId()))).collect(Collectors.toList());
		ObjectMapper mapper=new ObjectMapper();
		assertThat(actualSubCategories,hasItem(mapper.convertValue(subCategory,HashMap.class)));
	}
	
	
	private List<HashMap<String,Object>> getSubCategories() throws SQLException {
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("SELECT * FROM ecommerce1.sub_category");
		List<HashMap<String,Object>> actualSubCategories=new ArrayList<HashMap<String,Object>>();
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<HashMap<String,Object>> ref = new TypeReference<HashMap<String,Object>>() { };
		while(result.next()) {
			actualSubCategories.add(mapper.convertValue(new SubCategory().setSubCategoryId(result.getInt("sub_category_id"))
																		.setCategoryId(result.getInt("category_id"))
																		.setSubCategoryName(result.getString("sub_category_name")),ref));
		}
		return actualSubCategories;
	}
	
	
	@Test
	public void checkProducts(List<ProductDetails> products) throws SQLException {
		
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<HashMap<String,Object>>> ref = new TypeReference<List<HashMap<String,Object>>>() { };
		List<HashMap<String,Object>> list=mapper.convertValue(products, ref);
		
		List<HashMap<String,Object>> actualProducts=getProducts();
		
		assertTrue(actualProducts.containsAll(list) && actualProducts.size()==list.size());
		
	}
	
	
	
	@Test
	public void checkProductsUnderSubCategory(SubCategory subcategory,List<ProductDetails> products) throws SQLException {
		List<HashMap<String,Object>> actualProducts=getProducts().stream().filter(p->p.get("subCategoryId").equals(new Integer(subcategory.getSubCategoryId()))).collect(Collectors.toList());
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<HashMap<String,Object>>> ref = new TypeReference<List<HashMap<String,Object>>>() { };
		List<HashMap<String,Object>> list=mapper.convertValue(products, ref);
		
		assertTrue(actualProducts.containsAll(list) && actualProducts.size()==list.size());
		
	}
	
	
	@Test
	public void checkParticularProduct(ProductDetails product) throws  SQLException {
		ObjectMapper mapper=new ObjectMapper();
		assertThat(getProducts(),hasItem(mapper.convertValue(product,HashMap.class)));
	}


	private List<HashMap<String, Object>> getProducts() throws SQLException {
	
	
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("SELECT * FROM ecommerce1.product");
		List<HashMap<String,Object>> actualProducts=new ArrayList<HashMap<String,Object>>();
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<HashMap<String,Object>> ref = new TypeReference<HashMap<String,Object>>() { };
	
		while(result.next()) {
			actualProducts.add(mapper.convertValue(new ProductDetails()
													.setProductId(result.getInt("product_id"))
													.setProductName(result.getString("product_name"))
													.setProductPrice(result.getDouble("product_price"))
													.setProductQuantity(result.getInt("product_quantity"))
													.setSubCategoryId(result.getInt("sub_category_id")), ref));
		}
	
		return actualProducts;
	}
	
	
	@Test
	public void checkCartProducts(List<ProductDetails> products) throws SQLException {
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<HashMap<String,Object>>> ref = new TypeReference<List<HashMap<String,Object>>>() { };
		List<HashMap<String,Object>> list=mapper.convertValue(products, ref);
		
		List<HashMap<String, Object>> actualProducts=getCartProducts();
		
		assertTrue(actualProducts.containsAll(list) && actualProducts.size()==list.size());
		
	}
	
	
	@Test
	public void checkProductInCart(ProductDetails product) throws IllegalArgumentException, SQLException {
		ObjectMapper mapper=new ObjectMapper();
		assertThat(getCartProducts(),hasItem(mapper.convertValue(product,HashMap.class)));
	}
	

	private List<HashMap<String, Object>> getCartProducts() throws SQLException {
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("SELECT * FROM ecommerce1.cart");
		List<HashMap<String,Object>> actualProductsInCart=new ArrayList<HashMap<String,Object>>();
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<HashMap<String,Object>> ref = new TypeReference<HashMap<String,Object>>() { };
	
		while(result.next()) {
			actualProductsInCart.add(mapper.convertValue(new ProductDetails()
															.setProductId(result.getInt("product_id"))
															.setProductName(result.getString("product_name"))
															.setProductPrice(result.getDouble("product_price"))
															.setProductQuantity(result.getInt("cart_quantity")), ref));
		}
	
		return actualProductsInCart;
	}

}

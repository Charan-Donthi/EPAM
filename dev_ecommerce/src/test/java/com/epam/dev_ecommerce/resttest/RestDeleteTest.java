package com.epam.dev_ecommerce.resttest;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.objects.ProductDetails;
import com.epam.dev_ecommerce.objects.SubCategory;

public class RestDeleteTest extends RestTest{
	
	
	@Test
	public void deleteCategory(Category category, int expectedStatusCode) {
		request
			.when()
				.delete("/category/"+category.getCategoryId())
			.then()
				.assertThat()
					.statusCode(expectedStatusCode)
					.and()
					.body("categoryId",equalTo(category.getCategoryId()))
					.body("categoryName", equalTo(category.getCategoryName()));
	}
	
	@Test
	public void deleteSubCategory(SubCategory subcategory,int expectedStatusCode) {
		
		request
			.when()
				.delete("/subcategory/"+subcategory.getSubCategoryId())
			.then()
				.assertThat()
					.statusCode(expectedStatusCode)
					.and()
					.body("subCategoryId",equalTo(subcategory.getSubCategoryId()))
					.body("subCategoryName",equalTo(subcategory.getSubCategoryName()))
					.body("categoryId",equalTo(subcategory.getCategoryId()));
		
	}
	
	@Test
	public void deleteProduct(ProductDetails product,int expectedStatusCode) {
		
		request
			.when()
				.delete("/product/"+product.getProductId())
			.then()
				.assertThat()
					.statusCode(expectedStatusCode )
					.and()
					.body("productId",equalTo(product.getProductId()))
					.body("productName",equalTo(product.getProductName()))
					.body("productPrice",equalTo(product.getProductPrice()))
					.body("productQuantity",equalTo(product.getProductQuantity()))
					.body("subCategoryId",equalTo(product.getSubCategoryId()));
	}
	
	@Test
	public void deleteProductFromCart(ProductDetails product,int expectedStatusCode) {
		
		request
		.when()
			.delete("/cart/"+product.getProductId())
		.then()
			.assertThat()
				.statusCode(expectedStatusCode)
				.and()
				.body("productId",equalTo(product.getProductId()))
				.body("productName",equalTo(product.getProductName()))
				.body("productPrice",equalTo(product.getProductPrice()));
		
	}
	

}

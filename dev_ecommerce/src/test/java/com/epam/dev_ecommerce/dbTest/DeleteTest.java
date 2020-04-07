package com.epam.dev_ecommerce.dbTest;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.objects.ProductDetails;
import com.epam.dev_ecommerce.objects.SubCategory;

public class DeleteTest extends DbTest{
	
	@Test
	public void deleteCategory(Category category) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("DELETE FROM ecommerce1.category WHERE category_id='"+category.getCategoryId()+"'");
		assertTrue(rowsAffected==1);
	}
	
	@Test
	public void deleteSubCategory(SubCategory subCategory) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("DELETE FROM ecommerce1.sub_category WHERE sub_category_id='"+subCategory.getSubCategoryId()+"'");
		assertTrue(rowsAffected==1);
	}
	
	@Test
	public void deleteProduct(ProductDetails product) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("DELETE FROM ecommerce1.product WHERE product_id='"+product.getProductId()+"'");
		assertTrue(rowsAffected==1);
	}
	
	@Test
	public void deleteProductFromCart(ProductDetails product) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("DELETE FROM ecommerce1.cart WHERE product_id='"+product.getProductId()+"'");
		assertTrue(rowsAffected==1);
	}
	
}

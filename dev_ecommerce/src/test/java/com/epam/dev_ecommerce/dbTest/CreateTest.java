package com.epam.dev_ecommerce.dbTest;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.objects.ProductDetails;
import com.epam.dev_ecommerce.objects.SubCategory;

public class CreateTest extends DbTest{
	
	@Test
	public void insertCategory(Category category) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("INSERT INTO ecommerce1.category (category_name)"
												+"VALUES ('"+category.getCategoryName()+"')");
		assertTrue(rowsAffected==1);
	}
	
	@Test
	public void insertSubCategory(SubCategory subcategory) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("INSERT INTO ecommerce1.sub_category (category_id,sub_category_name)"
												+"VALUES ('"+subcategory.getCategoryId()+"','"+subcategory.getSubCategoryName()+"')");
		assertTrue(rowsAffected==1);
	}
	
	@Test
	public void insertProduct(ProductDetails product) throws SQLException {
		
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("INSERT INTO ecommerce1.product (product_name,product_price,product_quantity,sub_category_id)"
												+"VALUES ('"+product.getProductName()+"','"+product.getProductPrice()+"','"+product.getProductQuantity()+"','"+product.getSubCategoryId()+"')");
		assertTrue(rowsAffected==1);
		
	}
	
	@Test
	public void insertProductInCart(ProductDetails product) throws SQLException {
		
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("INSERT INTO ecommerce1.cart (product_id,product_name,product_price,cart_quantity)"
												+"VALUES ('"+product.getProductId()+"','"+product.getProductName()+"','"+product.getProductPrice()+"','"+product.getProductQuantity()+"')");
		assertTrue(rowsAffected==1);
		
	}
	
	
}
package com.epam.dev_ecommerce.dbTest;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.objects.ProductDetails;
import com.epam.dev_ecommerce.objects.SubCategory;

public class UpdateTest extends DbTest{
	
	@Test
	public void updateCategory(Category category) throws SQLException {
		
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("UPDATE ecommerce1.category"
												+ " SET category_name='"+category.getCategoryName()+"'"
												+"  WHERE category_id="+category.getCategoryId());
		
		assertTrue(rowsAffected==1);
	}
	
	@Test
	public void updateSubCategoryName(SubCategory subcategory) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("UPDATE ecommerce1.category"
												+ " SET sub_category_name='"+subcategory.getSubCategoryName()+"'"
												+"  WHERE sub_category_id="+subcategory.getSubCategoryId());
		
		assertTrue(rowsAffected==1);
	}
	
	
	@Test
	public void updateCategoryIdForSubCategory(SubCategory subcategory) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("UPDATE ecommerce1.category"
												+ " SET category_id='"+subcategory.getCategoryId()+"'"
												+"  WHERE sub_category_id="+subcategory.getSubCategoryId());
		
		assertTrue(rowsAffected==1);
	}
	
	@Test
	public void updateProduct(ProductDetails product) throws SQLException {
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("UPDATE ecommerce1.product"
												+ " SET product_name='"+product.getProductName()+"',"
												+ " product_price='"+product.getProductPrice()+"',"
												+ " product_quantity='"+product.getProductQuantity()+"',"
												+ " sub_category_id='"+product.getSubCategoryId()+"',"
												+"  WHERE product_id="+product.getProductId());
		
		assertTrue(rowsAffected==1);
	}
	
	@Test
	public void updateProductInCart(ProductDetails product) throws SQLException {
		
		Statement statement =connection.createStatement();
		int rowsAffected=statement.executeUpdate("UPDATE ecommerce1.cart"
												+ " SET product_name='"+product.getProductName()+"',"
												+ " product_price='"+product.getProductPrice()+"',"
												+ " cart_quantity='"+product.getProductQuantity()+"',"
												+"  WHERE product_id="+product.getProductId());
		
		assertTrue(rowsAffected==1);
		
	}
	

}

package com.databasetest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.database.DataBase;
import com.main.Category;
import com.main.Product;

public class DataBaseTest {
	
	DataBase db=new DataBase();

	@Test
	public void objectCreationTest() {
		assertNotNull(db);
	}
	
	@Test
	public void getEpamTest() {
		assertEquals("Epam",db.getEpam().getCategoryName());
	}
	
	@Test
	public void initializeCategoriesTest() {
		String[] categoryNames=new String[] {"Electronics","Fashion","Daily Essentials"};
		db.intializeCategories();
		int index=0;
		for(Category category:db.getEpam().getSubCategories()) {
			assertEquals(categoryNames[index++],category.getCategoryName());
		}
	}
	
	@Test
	public void initializeProductsTest() {
		String[] ProductNames=new String[] {};
		db.intializeProducts();
		int index=0;
		for(Product product:db.getEpam().getProducts()) {
			assertEquals(ProductNames[index++],product.getProductName());
		}
	}
	
	@Test
	public void initializeProductsTest1() {
		Product epamproduct=new Product("Epam Product");
		String[] ProductNames=new String[] {"Epam Product"};
		db.getEpam().addProduct(epamproduct);
		int index=0;
		for(Product product:db.getEpam().getProducts()) {
			assertEquals(ProductNames[index++],product.getProductName());
		}
	}

}

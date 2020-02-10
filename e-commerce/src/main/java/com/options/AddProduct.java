package com.options;

import Console.ConsoleFeatures.*;
import com.InputOutput.IO;
import com.main.Category;
import com.main.EpamTree;
import com.main.Product;



public class AddProduct extends Option {
	
	public AddProduct(String newOptionName) {
		
		setOptionName(newOptionName);
	}


	public void function() {
		
		Category category=(Category)EpamTree.getCurrentObject();
		
		if(addProduct(category)) {
			Console.println("Product Added Successfully under "+category.categoryName);
		}else {
			Console.println("Unable to add Product");
		}
		
	}
	
	
	private boolean addProduct(Category category) {
		String newProductName=getProductNameFromUser();
		
		for(Product product:category.getProducts()) {
			if(product.productName.equals(newProductName)) {
				Console.println("Product already exists");
				return false;
			}
		}
		
		return category.addProduct(new Product(newProductName));
	}
	
	private String getProductNameFromUser() {
		Console.println("Enter the Product name");
		return IO.readStringInput();
	}

}

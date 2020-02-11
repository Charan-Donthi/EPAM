package com.options;



import com.inputoutput.IO;
import com.main.Category;
import com.main.EpamTree;
import com.main.Product;



public class AddProduct extends Option {
	
	public AddProduct(String newOptionName) {
		
		setOptionName(newOptionName);
	}

	
	@Override
	public void function() {
		
		Category category=(Category)EpamTree.getCurrentObject();
		
		if(addProduct(category)) {
			logger.info("Product Added Successfully under {}",category.getCategoryName());
		}else {
			logger.warn("Unable to add Product");
		}
		
	}
	
	
	private boolean addProduct(Category category) {
		String newProductName=getProductNameFromUser();
		
		for(Product product:category.getProducts()) {
			if(product.getProductName().equals(newProductName)) {
				logger.warn("Product already exists");
				return false;
			}
		}
		
		return category.addProduct(new Product(newProductName));
	}
	
	private String getProductNameFromUser() {
		logger.info("Enter the Product name");
		return IO.readStringInput();
	}

}

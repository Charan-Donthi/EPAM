package com.options;

import java.util.Arrays;


import Console.ConsoleFeatures.*;

import com.inputoutput.IO;
import com.main.Category;
import com.main.EpamTree;
import com.main.Product;


public class RemoveProductUnderCategory extends RemoveProduct{

	public RemoveProductUnderCategory(String newOptionName) {
		super(newOptionName);
	}
	
	@Override
	public void function() {
		Category category=(Category)EpamTree.getCurrentObject();
		
		Console.Lister.list(Arrays.asList(category.getProducts().toArray()), 1);
		
		logger.info("Select the product to be removed");
		int index=IO.readIntInput();
		
		try {
			Product product=(Product) category.getProducts().toArray()[index-1];
			if(category.getProducts().remove(product)) {
				logger.info("Product removed successfully");
			}else {
				logger.warn("Unable to remove product");
			}
		}catch(IndexOutOfBoundsException e) {
			logger.error("Select from the given numbers");
		}
		
	}
	

}

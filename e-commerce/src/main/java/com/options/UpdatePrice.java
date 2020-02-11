package com.options;


import java.util.InputMismatchException;

import com.inputoutput.IO;
import com.main.EpamTree;
import com.main.Product;



public class UpdatePrice extends Option{
	
	
	public UpdatePrice(String newOptionName){
		setOptionName(newOptionName);
	}
	
	@Override
	public void function() {
		
		Product product=(Product)EpamTree.getCurrentObject();
		if(updatePrice(product)) {
			logger.info("Price Updated Successfully for {}",product.getProductName());
			}
		else {
			logger.info("Unable to update Price");
			}
		
	}
	
	public boolean updatePrice(Product product) {
		
		try {
			logger.info("Enter the Price:::");
		
		double newPrice=IO.readDoubleInput();
		if(newPrice<0) return false;
		product.setPrice(newPrice);
		return true;
		}catch(InputMismatchException e){
			logger.info("Invalid Price");
		}
		
		return false;
		
	}

}

package com.options;

import java.util.InputMismatchException;

import com.inputoutput.IO;
import com.main.EpamTree;
import com.main.Product;



public class UpdateQuantity extends Option{
	
	
	public UpdateQuantity(String newOptionName){
		setOptionName(newOptionName);
	}
	
	@Override
	public void function() {
		Product product=(Product)EpamTree.getCurrentObject();
		
		if(updateQuantity(product)) {
			logger.info("Quantity updated Successfully for {}",product.getProductName());
			}
		else {
			logger.info("Unable to update Quantity");
			}
	}
	
	public boolean updateQuantity(Product product) {
		
		try {
			logger.info("Enter the Quantity");
		
		int newQuantity=IO.readIntInput();
		if(newQuantity<0) {
			logger.info("Invalid Quantity");
			return false;
		}
		
		product.setQuantity(newQuantity);
		return true;
		}catch(InputMismatchException e) {
			logger.info("Invalid Input");
		}
		
		return false;
		
	}
}

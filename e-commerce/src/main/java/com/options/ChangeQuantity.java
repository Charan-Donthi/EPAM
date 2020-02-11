package com.options;


import java.util.InputMismatchException;

import com.inputoutput.IO;
import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;



public class ChangeQuantity extends Option{
		
	public ChangeQuantity(String newOptionName){
		setOptionName(newOptionName);
	}
	
	
	@Override
	public void function() {
		Cart yourCart=EpamTree.getYourCart();
		logger.info("Select Product to Change Quantity::::");
		int index=IO.readIntInput();
		
		try {
		
		Product product=(Product)yourCart.getProductsInCart().toArray()[index-1];
		
		if(changeQuantity(product)) {
			logger.info("Quantity changed successfully");
		}else {
			logger.warn("Unable to change quantity");
		}
		
		}catch(IndexOutOfBoundsException e) {
			logger.error("Select only from the given numbers");
		}
	}
	
	
	
	private boolean changeQuantity(Product product) {
		
		try {
			logger.info("Enter the Quantity::");
		
		int newQuantity=IO.readIntInput();
		
		if(newQuantity<0 && newQuantity>product.getQuantity()) {
			logger.warn("Invalid Quantity");
			return false;
		}else {
			product.setQuantity(newQuantity);
			return true;
		}
		}catch(InputMismatchException e) {
			logger.error("Invalid input");
		}
	return false;
}
}

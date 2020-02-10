package com.options;

import Console.ConsoleFeatures.*;

import java.util.InputMismatchException;

import com.InputOutput.IO;
import com.main.EpamTree;
import com.main.Product;



public class UpdatePrice extends Option{
	public UpdatePrice(String newOptionName){
		setOptionName(newOptionName);
	}
	
	public void function() {
		
		Product product=(Product)EpamTree.getCurrentObject();
		if(updatePrice(product)) {
			System.out.println("Price Updated Successfully for "+product.productName);
			}
		else {
			System.out.println("Unable to update Price");
			}
		
	}
	
	public boolean updatePrice(Product product) {
		
		try {
		Console.print("Enter the Price:::");
		
		double newPrice=IO.readDoubleInput();
		if(newPrice<0) return false;
		product.price=newPrice;
		return true;
		}catch(InputMismatchException e){
			Console.println("Invalid Price");
		}
		
		return false;
		
	}

}

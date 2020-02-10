package com.options;

import Console.ConsoleFeatures.*;

import java.util.InputMismatchException;

import com.InputOutput.IO;
import com.main.EpamTree;
import com.main.Product;



public class UpdateQuantity extends Option{
	public UpdateQuantity(String newOptionName){
		setOptionName(newOptionName);
	}
	
	public void function() {
		Product product=(Product)EpamTree.getCurrentObject();
		
		if(updateQuantity(product)) {
			System.out.println("Quantity updated Successfully for "+product.productName);
			}
		else {
			System.out.println("Unable to update Quantity");
			}
	}
	
	public boolean updateQuantity(Product product) {
		
		try {
		Console.print("Enter the Quantity");
		
		int newQuantity=IO.readIntInput();
		if(newQuantity<0) {
			Console.println("Invalid Quantity");
			return false;
		}
		
		product.quantity=newQuantity;
		return true;
		}catch(InputMismatchException e) {
			Console.println("Invalid Input");
		}
		
		return false;
		
	}
}

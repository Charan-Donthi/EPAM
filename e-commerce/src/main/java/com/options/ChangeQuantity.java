package com.options;

import Console.ConsoleFeatures.*;

import java.util.InputMismatchException;

import com.InputOutput.IO;
import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;



public class ChangeQuantity extends Option{
	
	public ChangeQuantity(String newOptionName){
		setOptionName(newOptionName);
	}
	
	
	
	public void function() {
		Cart yourCart=EpamTree.yourCart;
		Console.print("Select Product to Change Quantity::::");
		int index=IO.readIntInput();
		
		try {
		
		Product product=(Product)yourCart.getProductsInCart().toArray()[index-1];
		
		if(changeQuantity(product)) {
			Console.println("Quantity changed successfully");
		}else {
			Console.println("Unable to change quantity");
		}
		
		}catch(IndexOutOfBoundsException e) {
			Console.println("Select only from the given numbers");
		}
	}
	
	
	
	private boolean changeQuantity(Product product) {
		
		try {
		Console.println("Enter the Quantity::");
		
		int newQuantity=IO.readIntInput();
		
		if(newQuantity<0 && newQuantity>product.quantity) {
			Console.println("Invalid Quantity");
			return false;
		}else {
			product.quantity=newQuantity;
			return true;
		}
		}catch(InputMismatchException e) {
			Console.println("Invalid input");
		}
	return false;
}
}

package com.options;

import Console.ConsoleFeatures.*;
import com.InputOutput.IO;
import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;



public class RemoveProductFromCart extends RemoveProduct{

	public RemoveProductFromCart(String newOptionName) {
		super(newOptionName);
	}

	
	public void function() {
		
		Cart yourCart=EpamTree.yourCart;
		Console.print("Select Product to remove::::");
		int index=IO.readIntInput();
		
		try {
			
			Product product=(Product)yourCart.getProductsInCart().toArray()[index-1];
		
			if(removeProduct(yourCart,product)) {
				Console.println("Product removed successfully");
			}else {
				Console.println("Product not in Cart");
			}
		}catch(IndexOutOfBoundsException e) {
			Console.println("Select from the given numbers");
		}
		
	}
	
	private boolean removeProduct(Cart yourCart,Product product) {
		return yourCart.getProductsInCart().remove(product);
	}
}

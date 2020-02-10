package com.options;

import Console.ConsoleFeatures.*;
import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;


public class AddToCart extends Option{
	
	private Cart yourCart;
	
	public AddToCart(String newOptionName){
		setOptionName(newOptionName);
	}
	
	public void function() {
		
		this.yourCart=EpamTree.yourCart;
		Product product=(Product)EpamTree.getCurrentObject();
		
		if(isProductInCart(product)) {
			addToCart(new Product(product));
			Console.println(product.productName+" added Successfully");
		}else {
			Console.println("Product already exists");
			}
	}
	
	private void addToCart(Product product) {
		
		yourCart.addToCart(product);
		
	}
	
	private boolean isProductInCart(Product product) {
		for(Product productInCart:yourCart.getProductsInCart()) {
			if(productInCart.productName.equals(product.productName))	return false;
		}
		return true;
	}
	
	
	
}

package com.options;

import Console.ConsoleFeatures.*;

import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;



public class ConfirmOrder extends Option{
	public ConfirmOrder(String newOptionName){
		setOptionName(newOptionName);
	}
	
	public void function() {
		
		Cart yourCart=EpamTree.yourCart;
		
		Option showcart=new ShowCart("show cart");
		showcart.function();
		
		if(!yourCart.getProductsInCart().isEmpty()) {
			deductQuantityFromDataBase(yourCart);
			Console.println("---------------Your Order-----------------");
			Console.println("---Is on its way make sure to collect-----");
			System.exit(0);
		}
		
	}
	
	
	private void deductQuantityFromDataBase(Cart yourCart) {
		for(Product cartProduct:yourCart.getProductsInCart()) {
			Product originalProduct=EpamTree.allProducts.get(cartProduct.productName);
			originalProduct.quantity-=cartProduct.quantity;
		}
	}
}

package com.options;

import Console.ConsoleFeatures.*;
import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;


public class ShowCart extends Option{
	public ShowCart(String newOptionName){
		setOptionName(newOptionName);
	}
	
	public void function() {
		
		Cart yourCart=EpamTree.yourCart;
		EpamTree.branch.add(yourCart);
		EpamTree.displayCurrentBranch("Cart");
		
		
		if(yourCart.getProductsInCart().isEmpty()) {
			Console.println("Your cart is empty");
			CheckOut.getInstance().function();
		}else {
			int count=0;
			yourCart.setTotalPrice(0);
			for(Product product:yourCart.getProductsInCart()) {
				Console.println(++count+"-------"+product.productName+"-------"+product.quantity+"-------"+product.price*product.quantity);
				yourCart.setTotalPrice(yourCart.getTotalPrice() + product.price*product.quantity);
			}
			Console.println("Total Price="+yourCart.getTotalPrice());
		
		}
		EpamTree.displayCurrentBranch("Cart");
	}
	
}

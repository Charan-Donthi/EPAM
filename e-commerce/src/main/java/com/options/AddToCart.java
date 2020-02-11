package com.options;


import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;


public class AddToCart extends Option{
	
	private Cart yourCart;
	
	public AddToCart(String newOptionName){
		setOptionName(newOptionName);
	}
	
	@Override
	public void function() {
		
		this.yourCart=EpamTree.getYourCart();
		Product product=(Product)EpamTree.getCurrentObject();
		
		if(isProductInCart(product)) {
			addToCart(new Product(product));
			logger.info("{} added Successfully",product.getProductName());
		}else {
			logger.warn("Product already exists");
			}
	}
	
	private void addToCart(Product product) {
		
		yourCart.addToCart(product);
		
	}
	
	private boolean isProductInCart(Product product) {
		for(Product productInCart:yourCart.getProductsInCart()) {
			if(productInCart.getProductName().equals(product.getProductName()))	return false;
		}
		return true;
	}
	
	
	
}

package com.main;

import java.util.LinkedHashSet;
import java.util.Set;

public class Cart {
	
	private Set<Product> productsInCart=new LinkedHashSet<Product>();
	private double totalPrice=0;
	
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public boolean addToCart(Product product) {
		return productsInCart.add(product);
	}
	public Set<Product> getProductsInCart() {
		return productsInCart;
	}
	public void setProductsInCart(Set<Product> productsInCart) {
		this.productsInCart = productsInCart;
	}
	
}


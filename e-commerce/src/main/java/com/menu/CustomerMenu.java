package com.menu;

import com.main.Product;

public interface CustomerMenu extends UserMenu,CartMenu{
	public boolean addToCart(Product product);
	public void confirmOrder();
	
}

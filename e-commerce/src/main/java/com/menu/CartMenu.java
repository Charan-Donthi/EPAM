package com.menu;

import com.main.Product;

public interface CartMenu extends UserMenu {
	public boolean removeProduct(Product product);
	public boolean changeQuantity(Product product);
}

package com.menu;

import com.main.Category;
import com.main.Product;;

public interface AdminMenu extends UserMenu {
	public boolean addCategory(Category category);
	public boolean addProduct(Category category);
	public boolean updateQuantity(Product product);
	public boolean updatePrice(Product product);
}

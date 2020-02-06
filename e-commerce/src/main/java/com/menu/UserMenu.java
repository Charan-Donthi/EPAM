package com.menu;
import com.main.Category;
import com.main.Product;;


public interface UserMenu extends Menu {
	public void checkOut();
	public void showCategories(Category category);
	public void showProducts(Category category);
	public void selectProduct(Product product);
}

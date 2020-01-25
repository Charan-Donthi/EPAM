package com.appInterface;

import com.IO.*;
import com.main.Category;
import com.main.EpamTree;
import com.main.Product;
import com.menu.Menu;
import com.menu.UserMenu;


public class UserInterface implements Menu,UserMenu {
	
	
	public void displayUserMenu() {
		
		AdminInterface admin=new AdminInterface();
		
		System.out.println("--------------\n1.Admin\n2.Customer\n3.Exit");
		EpamTree.requestOption();
		
		switch(IO.readIntInput()) {
		case 1:
			admin.displayAdminMenu();
			System.out.println("Your in Initial Page");
			break;
		case 2:
			CustomerInterface customer=new CustomerInterface();
			customer.displayCustomerMenu();
			System.out.println("Your in Initial Page");
			break;
		case 3:
			Exit();
		default:
			System.out.println("Select from given Options");	
		}
		displayUserMenu(); 
	}
	
	
	
	public void checkOut(){
		if(EpamTree.branch.size()==1)  return;
		EpamTree.branch.remove(EpamTree.branch.size()-1);
	}
	
	
	
	public void showCategories(Category category){
		int count=0;
		for(Category subCategory:category.subCategories) {
			System.out.println(++count+"."+subCategory.categoryName);
		}
	}
	
	
	
	public void showProducts(Category category){
		if(category.productsInCategory.size()<=0) {
			System.out.println("Their aren't any Products in this category");
			return;
		}
		
		for(Product product:category.productsInCategory) {
			System.out.println(product.productName);
		}
	}
	
	
	
	public void selectProduct(Product product) {
		System.out.println(product.productName);
	}
	
	
	
	public void Exit() {
		System.exit(0);
	}
	

}

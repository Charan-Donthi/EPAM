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
		
		System.out.println("1.Admin\n2.Customer\n3.Exit");
		
		switch(IO.readIntInput()) {
		case 1:
			admin.displayAdminMenu();
			break;
		case 2:
			
			CustomerInterface customer=new CustomerInterface();
			customer.displayCustomerMenu();
			break;
		case 3:
			Exit();
		default:
			System.out.println("Select from given Options");	
		}
	}
	
	
	
	public void checkOut(){
		if(EpamTree.branch.size()>1) {
			EpamTree.branch.remove(EpamTree.branch.size()-1);
		}else {System.out.println("Your in initial Page");}
	}
	
	
	
	public void showCategories(Category category){
		for(Category subCategory:category.subCategories) {
			System.out.println(subCategory.categoryName);
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

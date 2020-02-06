package com.appInterface;

import com.IO.*;
import com.main.Category;
import com.main.EpamTree;
import com.main.Product;
import com.menu.Menu;
import com.menu.UserMenu;


public class UserInterface implements Menu,UserMenu {
	
	
	public void displayUserMenu() {
		
		
		
		System.out.println("--------------\n1.Admin\n2.Customer\n3.Exit");
		EpamTree.showCurrentBranch(EpamTree.generatePath());
		System.out.print("Select option:::::");
		
		switch(IO.readIntInput()) {
		case 1:
			AdminInterface admin=new AdminInterface();
			EpamTree.user=admin;
			admin.displayAdminMenu();
			break;
		case 2:
			CustomerInterface customer=new CustomerInterface();
			EpamTree.user=customer;
			customer.displayCustomerMenu();
			break;
		case 3:
			Exit();
		default:
			System.out.println("Select from given Options");	
		}
		
		displayUserMenu();
	}
	
	
	
	public void checkOut(){
		if(!(EpamTree.branch.size()==1)) {
		EpamTree.branch.remove(EpamTree.branch.size()-1);	}
		else{
		EpamTree.checkOutStatus=true;
		}
	}
	
	
	
	public void showCategories(Category category){
		if(category.subCategories.isEmpty()) {System.out.println("No categories under "+ category.categoryName); return;}
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
			System.out.println(product.productName+" ----Price:"+product.price+" ----Quantity:"+product.quantity);
		}
	}
	
	
	
	public void selectProduct(Product product) {
		System.out.println(product.productName);
	}
	
	
	
	public void Exit() {
		System.exit(0);
	}
	

}

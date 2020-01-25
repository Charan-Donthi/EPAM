package com.appInterface;

import com.IO.*;

import com.main.Category;
import com.main.EpamTree;
import com.main.Product;
import com.menu.AdminMenu;

public class AdminInterface extends UserInterface implements AdminMenu {
	
	public void displayAdminMenu() {
		System.out.println("------------------\n1.Show Categories\n2.Show Products\n3.Select Product\n4.Add Category\n5.Add Product\n6.Update Quantity\n7.Update Price\n8.CHECK OUT\n9.Exit");
		EpamTree.requestOption();
		
		Object o=EpamTree.getCurrentObject();
		
		String input=IO.readStringInput();
		
		if(isNumeric(input)) {
		switch(Integer.parseInt(input)) {
		case 1:
			if(EpamTree.isCategory(o)) {
				showCategories((Category)o);
			}else {System.out.println("Product cannot have categories");}
			break;
		case 2:
			if(EpamTree.isCategory(o)) {
				showProducts((Category)o);
				}else {System.out.println("Product cannot have products");}
			break;
		case 3:
			if(EpamTree.isProduct(o)) {
				selectProduct((Product)o);
			}else {System.out.println("Cannot select category");}
			break;
		case 4:
			if(EpamTree.isCategory(o)) {
				if(addCategory((Category)o)) {System.out.println("Category Added Successfully under "+((Category)o).categoryName);}
				else {System.out.println("Unable to add category");}
			}else {System.out.println("Cannot Add Category under Product");}
			break;
		case 5:
			if(EpamTree.isCategory(o)) {
				if(addProduct((Category)o)) {System.out.println("Product Added Successfully under "+((Category)o).categoryName);}
				else {System.out.println("Unable to add Product");}
			}else {System.out.println("Cannot Add Product under Product");}
			break;
		case 6:
			if(EpamTree.isProduct(o)) {
				if(updateQuantity((Product)o)) {System.out.println("Quantity updated Successfully for "+((Product)o).productName);}
				else {System.out.println("Unable to update Quantity");}
			}else {System.out.println("Choose Product Instead Category");}
			break;
		case 7:
			if(EpamTree.isProduct(o)) {
				if(updatePrice((Product)o)) {System.out.println("Price Updated Successfully for "+((Product)o).productName);}
				else {System.out.println("Unable to update Price");}
			}else {System.out.println("Choose Product Instead Category");}
			break;
		case 8:
			checkOut();
			return;
		case 9:
			Exit();
		default:
			System.out.println("Select Only from given Options");	
		}
		}
		EpamTree.traverse(input);
		displayAdminMenu();
	}

	
	
	public boolean addCategory(Category category) {
		System.out.println("Enter the category name:");
		
		String newSubCategoryName=IO.readStringInput();
		
		for(Category subcategory:category.subCategories) {
			if(subcategory.categoryName.equals(newSubCategoryName)) {
				System.out.println("Category already exists");
				return false;
			}
		}
		
		return category.subCategories.add(new Category(newSubCategoryName));
	}
	
	
	
	public boolean addProduct(Category category) {
		System.out.println("Enter the Product name");
		
		String newProductName=IO.readStringInput();
		
		for(Product product:category.productsInCategory) {
			if(product.productName.equals(newProductName)) {
				System.out.println("Product already exists");
				return false;
			}
		}
		
		return category.productsInCategory.add(new Product(newProductName));
	}
	
	
	
	public boolean updateQuantity(Product product) {
		System.out.println("Enter the Quantity");
		
		int newQuantity=IO.readIntInput();
		if(newQuantity<0) {
			System.out.println("Invalid Quantity");
			return false;
		}
		
		product.quantity=newQuantity;
		return product.quantity==newQuantity;
		
	}
	
	
	
	public boolean updatePrice(Product product) {
		System.out.println("Enter the Price");
		
		double newPrice=IO.readDoubleInput();
		if(newPrice<0) {
			System.out.println("Invalid Price");
			return false;
		}
		
		product.price=newPrice;
		return product.price==newPrice;
	}
	
	
	public boolean isNumeric(String string) {
		try {
			Integer.parseInt(string);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	
}

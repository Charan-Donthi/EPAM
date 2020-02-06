package com.appInterface;

import com.IO.*;

import com.main.Category;
import com.main.EpamTree;
import com.main.Product;
import com.menu.AdminMenu;

public class AdminInterface extends UserInterface implements AdminMenu {
	
	
	public void displayAdminMenu() {
		EpamTree.checkOutStatus=false;
		FieldMenu.currentFieldMenu();
		if(EpamTree.checkOutStatus)	return;
		displayAdminMenu();
		
	}
	
	
	
	public void categoryMenu(Object o) {
		System.out.println("------------------\n1.Show Categories\n2.Show Products\n3.Add Category\n4.Add Product\n5.CHECK OUT\n6.Exit");
		
		EpamTree.requestOption();
		String input=IO.readStringInput();
		
		if(isNumeric(input)) {
		switch(Integer.parseInt(input)) {
		case 1:
			showCategories((Category)o);
			break;
		case 2:
			showProducts((Category)o);
			break;
		case 3:
			if(addCategory((Category)o)) {System.out.println("Category Added Successfully under "+((Category)o).categoryName);}
			else {System.out.println("Unable to add category");}
			break;
		case 4:
			if(addProduct((Category)o)) {System.out.println("Product Added Successfully under "+((Category)o).categoryName);}
			else {System.out.println("Unable to add Product");}
			break;
		case 5:
			checkOut();
			break;
		case 6:
			Exit();
		default:
			System.out.println("Select Only from given Options");	
		}
		}else {EpamTree.traverse(input);}
		
		
	}
	
	public void productMenu(Object o) {
		System.out.println("------------------\n1.Update Quantity\n2.Update Price\n3.CHECK OUT\n4.Exit");
		EpamTree.requestOption();
		String input=IO.readStringInput();
		if(isNumeric(input)) {	
			switch(Integer.parseInt(input)) {
			case 1:
				if(updateQuantity((Product)o)) {System.out.println("Quantity updated Successfully for "+((Product)o).productName);}
				else {System.out.println("Unable to update Quantity");}
				break;
			case 2:
				if(updatePrice((Product)o)) {System.out.println("Price Updated Successfully for "+((Product)o).productName);}
				else {System.out.println("Unable to update Price");}
				break;
			case 3:
				checkOut();
				break;
			case 4:
				Exit();
			default:
				System.out.println("Select Only from given Options");
			}
		}else {EpamTree.traverse(input);}
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

package com.appInterface;

import com.IO.IO;
import com.main.Cart;
import com.main.Category;
import com.main.EpamTree;
import com.main.Product;
import com.menu.CustomerMenu;

public class CustomerInterface extends UserInterface implements CustomerMenu {
	Cart yourCart;
	
	
	
	public CustomerInterface() {
		yourCart=new Cart();
	}
		
	
	
	public void displayCustomerMenu() {
		
		System.out.println("------------------\n1.Show Categories\n2.Show Products\n3.Select Product\n4.Add To Cart\n5.Show Cart\n6.Confirm Order\n7.CHECK OUT\n8.Exit");
		EpamTree.requestOption();
		
		Object o=EpamTree.getCurrentObject();
		
		switch(Integer.parseInt(IO.readStringInput())) {
		case 1:
			if(EpamTree.isCategory(o)) {
				showCategories((Category)o);
			}else {System.out.println("Product cannot have categories under it");}
			break;
		case 2:
			if(EpamTree.isCategory(o)) {
			showProducts((Category)o);
			}else {System.out.println("Products cannot have products under it");}
			break;
		case 3:
			if(EpamTree.isProduct(o)) {
				selectProduct((Product)o);
			}else {System.out.println("Cannot select category");}
			break;
		case 4:
			if(EpamTree.isProduct(o)) {
				if(addToCart((Product)o)) {
					System.out.println(((Product)o).productName+" added Successfully");
				}else {System.out.println("Unable to add");}
				}else {System.out.println("Category Cannot be added to Cart");}
			break;
		case 5:
			showCart();
			break;
		case 6:
			confirmOrder();
			break;
		case 7:
			checkOut();
			return;
		case 8:
			Exit();
		default:
			System.out.println("Select Only from given Options");	
		}
		displayCustomerMenu();
	}
	
	
	
	
	public void showProducts(Category category){
		if(category.productsInCategory.size()<=0) {
			System.out.println("Their aren't any Products in this category");
			return;
		}
		
		for(Product product:category.productsInCategory) {
			System.out.println(product.productName+"-----------"+product.price);
		}
	}
	
	
	
	public boolean addToCart(Product product) {
		
		if(isProductInCart(product)) {
			System.out.println("Product already exists");
			return false;
		}
		
		Product clonedProduct;
		try {
		clonedProduct=(Product)product.clone();
		clonedProduct.quantity=1;
		}catch(CloneNotSupportedException e) {
			return false;
		}
		
		return yourCart.productsInCart.add(clonedProduct);
	}
	
	
	
	public void showCart() {
		if(yourCart.productsInCart.isEmpty()) {
			System.out.println("Your cart is empty");
			return;
		}
		int count=0;
		for(Product product:yourCart.productsInCart) {
			System.out.println(++count+"-------"+product.productName+"-------"+product.quantity+"-------"+product.price*product.quantity);
			yourCart.totalPrice+=product.price*product.quantity;
		}
		System.out.println("Total Price="+yourCart.totalPrice);
		diplayCartMenu();
	}
	
	
	
	
	public void diplayCartMenu() {
		System.out.println("1.Remove Product\n2.Change Quantity\n3..Check Out");
		switch(IO.readIntInput()){
		case 1:
			System.out.println("Select Product to remove");
			break;
		case 2:
			return;
		default:
			System.out.println("Enter valid option");
		}
		System.out.println("\n1.Remove Product\n2.Change Quantity");
		
	}
	
	

	
	public boolean removeProduct(Product product) {
		return yourCart.productsInCart.remove(product);
	}
	
	
	
	public boolean changeQuantity(Product product) {
		System.out.println("Enter the Quantity");
		
		for(Product cartProduct:yourCart.productsInCart) {
			if(cartProduct.equals(product)) {
				int newQuantity=IO.readIntInput();
				if(newQuantity<0) {
					System.out.println("Invalid Quantity");
					return false;
				}
				cartProduct.quantity=product.quantity;
				return cartProduct.quantity==product.quantity;
			}
		}
		
		System.out.println("Product Not found");
		return false;
	}
	
	
	
	public void confirmOrder() {
		System.out.println("---------------Your Order-----------------");
		showCart();
		System.out.println("---Is on its way make sure to collect-----");
		Exit();
	}
	
	
	
	public boolean isProductInCart(Product product) {
		for(Product cartProduct:yourCart.productsInCart) {
			if(cartProduct.productName.equals(product.productName)) return true;
		}	
		return false;
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

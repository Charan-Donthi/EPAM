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
		EpamTree.checkOutStatus=false;
		FieldMenu.currentFieldMenu();
		if(EpamTree.checkOutStatus)	return;
		displayCustomerMenu();
	}
	
	
	
	public void categoryMenu(Object o) {
		System.out.println("------------------\n1.Show Categories\n2.Show Products\n3.Show Cart\n4.Confirm Order\n5.CHECK OUT\n6.Exit");
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
			showCart();
			break;
		case 4:
			confirmOrder();
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
		System.out.println("------------------\n1.Add to Cart\n2.CHECK OUT\n3.Exit");
		EpamTree.requestOption();
		String input=IO.readStringInput();
		
		if(isNumeric(input)) {
			switch(Integer.parseInt(input)) {	
			case 1:
				if(addToCart((Product)o)) {
					System.out.println(((Product)o).productName+" added Successfully");
				}else {System.out.println("Unable to add");}
				break;
			case 2:
				checkOut();
				break;
			case 3:
				Exit();
			default:
				System.out.println("Select Only from given Options");
			}
		}else {EpamTree.traverse(input);}
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
		EpamTree.showCurrentBranch("Cart");
		if(yourCart.productsInCart.isEmpty()) {
			System.out.println("Your cart is empty");
			EpamTree.showCurrentBranch("Cart");
			return;
		}
		int count=0;
		for(Product product:yourCart.productsInCart) {
			System.out.println(++count+"-------"+product.productName+"-------"+product.quantity+"-------"+product.price*product.quantity);
			yourCart.totalPrice+=product.price*product.quantity;
		}
		System.out.println("Total Price="+yourCart.totalPrice);
		EpamTree.showCurrentBranch("Cart");
		cartMenu();
	}
	
	
	
	
	public void cartMenu() {
		System.out.println("1.Remove Product\n2.Change Quantity\n3.Check Out");
		System.out.print("Select Option::::");
		switch(IO.readIntInput()){
		case 1:
			System.out.println("Select Product to remove::::");
			try {
			if(removeProduct((Product)yourCart.productsInCart.toArray()[IO.readIntInput()-1])) {
				System.out.println("Product removed from cart");}
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
		case 2:
			System.out.println("Select Product to Change Quantity::::");
			try {
				if(changeQuantity((Product)yourCart.productsInCart.toArray()[IO.readIntInput()-1])) {
					System.out.println("Quantity changed");}
				}catch(Exception e) {
					System.out.println(e.toString());
				}
			return;
		default:
			System.out.println("Enter valid option");
		}
		
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
				cartProduct.quantity=newQuantity;
				return cartProduct.quantity==newQuantity;
			}
		}
		
		System.out.println("Product Not found");
		return false;
	}
	
	
	
	public void confirmOrder() {
		showCart();
		System.out.println("---------------Your Order-----------------");
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

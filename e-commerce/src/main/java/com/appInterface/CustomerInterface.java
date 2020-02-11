package com.appinterface;

import com.main.Cart;
import com.main.Category;
import com.main.EpamTree;
import com.main.Product;
import com.options.CartOptions;
import com.options.CategoryOptionsForCustomer;
import com.options.ProductOptionsForCustomer;

public class CustomerInterface extends UserInterface {
	 Cart yourCart;
	
	 CategoryOptionsForCustomer categoryOptions=new CategoryOptionsForCustomer();
	 ProductOptionsForCustomer productOptions=new ProductOptionsForCustomer();
	 CartOptions cartOptions=new CartOptions();
	
	
	public CustomerInterface(String user) {
		this.user=user;
		yourCart=new Cart();
		EpamTree.setYourCart(yourCart);
	}
		
	
	@Override
	public void displayMenu() {
		
		EpamTree.setCheckOutStatus(false);
		
		if(EpamTree.getCurrentObject() instanceof Category) {categoryMenu();}
		
		if(EpamTree.getCurrentObject() instanceof Product) {productMenu();}
		
		if(EpamTree.getCurrentObject() instanceof Cart) {cartMenu();}
		
		if(EpamTree.isCheckOutStatus())	return;
		
		displayMenu();
	}
	
	
	
	public void categoryMenu() {
		categoryOptions.listOptions();
		
		String input=EpamTree.requestOption();
		
		if(isNumeric(input)) {
			categoryOptions.selectOption(Integer.parseInt(input));
		}else {EpamTree.traverse(input);}
	}
	
	
	
	public void productMenu() {
		productOptions.listOptions();
		
		String input=EpamTree.requestOption();
		
		if(isNumeric(input)) {
			productOptions.selectOption(Integer.parseInt(input));
		}else {EpamTree.traverse(input);}
	}
	

	
	
	
	public void cartMenu() {
		cartOptions.listOptions();
		
		String input=EpamTree.requestOption();
		
		if(isNumeric(input)) {
			cartOptions.selectOption(Integer.parseInt(input));
		}else {EpamTree.traverse(input);}
		
	}
	
	
	
	public boolean isNumeric(String string) {
		try {
			Integer.parseInt(string.trim());
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
}

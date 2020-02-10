package com.appInterface;

import com.main.EpamTree;
import com.main.Product;
import com.main.Category;
import com.options.CategoryOptionsForAdmin;
import com.options.ProductOptionsForAdmin;

public class AdminInterface extends UserInterface {
	
	public AdminInterface(String user){
		this.user=user;
	}
	
	CategoryOptionsForAdmin categoryOptions=new CategoryOptionsForAdmin();
	ProductOptionsForAdmin productOptions=new ProductOptionsForAdmin();
	
	
	
	public void displayMenu() {
		
		EpamTree.checkOutStatus=false;
		
		if(EpamTree.getCurrentObject() instanceof Category) {categoryMenu();}
		
		if(EpamTree.getCurrentObject() instanceof Product) {productMenu();}
		
		if(EpamTree.checkOutStatus)	return;
		
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

	
	
	public boolean isNumeric(String string) 
	{
		try {
			Integer.parseInt(string);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}


	
	
}

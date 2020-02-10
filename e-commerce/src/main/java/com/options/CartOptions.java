package com.options;

import java.util.ArrayList;
import java.util.List;

import Console.ConsoleFeatures.Console;

public class CartOptions {
	private List<Option> optionsList=new ArrayList<>();
	
	public CartOptions(){
		initializeOptions();
	}
	
	private void initializeOptions() {

		optionsList.add(new RemoveProductFromCart("Remove Product"));
		optionsList.add(new ChangeQuantity("Change Quantity"));
		optionsList.add(new ConfirmOrder("Confirm Order"));
		optionsList.add(CheckOut.getInstance());
		optionsList.add(Exit.getInstance());
	}
	
	public void listOptions() {
		Console.Liner.line("-", 20);
		Console.println();
		int optionNumber=1;
		for(Option option:optionsList) {
			Console.println(optionNumber+++"."+option.getOptionName());
		}
	
	}
	
	public void selectOption(int optionNumber) {
		try {
		optionsList.get(optionNumber-1).function();
		}catch(IndexOutOfBoundsException e) {
			Console.println("Select from the given numbers");
		}
	}

}

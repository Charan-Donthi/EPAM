package com.options;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


import Console.ConsoleFeatures.Console;

public class CategoryOptionsForCustomer {
	
	final Logger logger=(Logger) LogManager.getLogger(CategoryOptionsForCustomer.class);
	
	private List<Option> optionsList=new ArrayList<>();
	
	public CategoryOptionsForCustomer(){
		initializeOptions();
	}
	
	private void initializeOptions() {
		optionsList.add(new ShowCategories("Show Categories"));
		optionsList.add(new ShowProducts("Show Products"));
		optionsList.add(new ShowCart("Show cart"));
		optionsList.add(new ConfirmOrder("Confirm Order"));
		optionsList.add(CheckOut.getInstance());
		optionsList.add(Exit.getInstance());
	}
	
	public void listOptions() {
		Console.Liner.line("-", 20);
		Console.println();
		int optionNumber=1;
		for(Option option:optionsList) {
			logger.info("{}.{}",optionNumber++,option.getOptionName());
		}
	
	}
	
	public void selectOption(int optionNumber) {
		try {
		optionsList.get(optionNumber-1).function();
		}catch(IndexOutOfBoundsException e) {
			logger.info("Select from the given numbers");
		}
	}
}

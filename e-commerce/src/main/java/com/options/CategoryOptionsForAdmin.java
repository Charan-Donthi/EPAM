package com.options;


import java.util.ArrayList;
import java.util.List;
import Console.ConsoleFeatures.*;



public class CategoryOptionsForAdmin {
	
	private List<Option> optionsList=new ArrayList<>();
	
	public CategoryOptionsForAdmin(){
		initializeOptions();
	}
	
	private void initializeOptions() {
		optionsList.add(new ShowCategories("Show Categories"));
		
		optionsList.add(new ShowProducts("Show Products"));
		optionsList.add(new AddCategory("Add Category"));
		optionsList.add(new AddProduct("Add Product"));
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

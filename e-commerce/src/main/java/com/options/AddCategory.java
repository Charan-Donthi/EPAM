package com.options;


import com.InputOutput.IO;
import com.main.Category;
import com.main.EpamTree;

import Console.ConsoleFeatures.*;



public class AddCategory extends Option {
	
	
	public AddCategory(String newOptionName) {
		setOptionName(newOptionName);
		
	}


	public void function() 
	{
		Category category=(Category)EpamTree.getCurrentObject();
		if(addCategoryUnder(category)) {
			Console.println("Category Added Successfully under "+category.categoryName);
			
		}else {
			Console.println("Unable to add category!..");
		}
		
	}
	

	private boolean addCategoryUnder(Category category) {
		
		String newSubCategoryName=getCategoryNameFromUser();
		
		for(Category subcategory:category.getSubCategories()) {
			if(subcategory.categoryName.equals(newSubCategoryName)) {
				Console.println("Category already exists");
				return false;
			}
		}
		
		return category.getSubCategories().add(new Category(newSubCategoryName));
	}
	
	
	private String getCategoryNameFromUser() {
		Console.print("Enter the category name:::");
		return IO.readStringInput();
	}

}

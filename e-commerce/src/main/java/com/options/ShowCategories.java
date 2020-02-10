package com.options;

import Console.ConsoleFeatures.*;
import com.main.Category;
import com.main.EpamTree;


public class ShowCategories extends Option 
{
	
	public ShowCategories(String newOptionName){
		setOptionName(newOptionName);
	}
	
	public void function() 
	{
		Category category=(Category)EpamTree.getCurrentObject();
		if(category.getSubCategories().isEmpty()) 
		{
			Console.println("No categories under "+ category.categoryName); 
			return;
		}
		for(Category subCategory:category.getSubCategories()) 
		{
			Console.println(subCategory.categoryName);
		}
	}
	
	
}

package com.options;



import com.main.Category;
import com.main.EpamTree;


public class ShowCategories extends Option 
{
	
	public ShowCategories(String newOptionName){
		setOptionName(newOptionName);
	}
	
	@Override
	public void function() 
	{
		Category category=(Category)EpamTree.getCurrentObject();
		if(category.getSubCategories().isEmpty()) 
		{
			logger.info("No categories under {}", category.getCategoryName()); 
			return;
		}
		for(Category subCategory:category.getSubCategories()) 
		{
			logger.info(subCategory.getCategoryName());
		}
	}
	
	
}

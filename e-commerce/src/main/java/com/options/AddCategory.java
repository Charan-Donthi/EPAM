package com.options;



import com.inputoutput.IO;
import com.main.Category;
import com.main.EpamTree;




public class AddCategory extends Option {
	
	
	public AddCategory(String newOptionName) {
		setOptionName(newOptionName);
		
	}

	
	@Override
	public void function() 
	{
		Category category=(Category)EpamTree.getCurrentObject();
		if(addCategoryUnder(category)) {
			logger.info("Category Added Successfully under {}",category.getCategoryName());
			
		}else {
			logger.warn("Unable to add category!..");
		}
		
	}
	

	private boolean addCategoryUnder(Category category) {
		
		String newSubCategoryName=getCategoryNameFromUser();
		
		for(Category subcategory:category.getSubCategories()) {
			if(subcategory.getCategoryName().equals(newSubCategoryName)) {
				logger.warn("Category already exists");
				return false;
			}
		}
		
		return category.getSubCategories().add(new Category(newSubCategoryName));
	}
	
	
	private String getCategoryNameFromUser() {
		logger.info("Enter the category name:::");
		return IO.readStringInput();
	}

}

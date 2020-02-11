package com.options;



import com.main.Category;
import com.main.EpamTree;
import com.main.Product;



public class ShowProducts extends Option 
{
	
	
	public ShowProducts(String newOptionName){
		setOptionName(newOptionName);
	}
	
	@Override
	public void function() 
	{
		Category category=(Category)EpamTree.getCurrentObject();
		if(category.getProducts().isEmpty()) 
		{
			logger.warn("Their aren't any Products in this category");
			return;
		}
		
		for(Product product:category.getProducts()) 
		{
			logger.info("{} ----Price:{} ----Quantity:{}",product.getProductName(),product.getPrice(),product.getQuantity());
		}
	}

}

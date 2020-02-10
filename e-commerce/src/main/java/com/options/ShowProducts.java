package com.options;

import Console.ConsoleFeatures.*;
import com.main.Category;
import com.main.EpamTree;
import com.main.Product;



public class ShowProducts extends Option 
{
	public ShowProducts(String newOptionName){
		setOptionName(newOptionName);
	}
	
	
	public void function() 
	{
		Category category=(Category)EpamTree.getCurrentObject();
		if(category.getProducts().size()<=0) 
		{
			Console.println("Their aren't any Products in this category");
			return;
		}
		
		for(Product product:category.getProducts()) 
		{
			Console.println(product.productName+" ----Price:"+product.price+" ----Quantity:"+product.quantity);
		}
	}

}


package com.main;

import java.util.Set;
import java.util.LinkedHashSet;


public class Category {
	public String categoryName;
	public Set<Category> subCategories=new LinkedHashSet<Category>();
	public Set<Product> productsInCategory=new LinkedHashSet<Product>();
	
	public Category(String categoryName) {
		this.categoryName=categoryName;
	}

}

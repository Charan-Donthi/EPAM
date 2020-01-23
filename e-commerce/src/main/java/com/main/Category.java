/**
 * 
 */
package com.main;

import java.util.Set;
import java.util.LinkedHashSet;


/**
 * @author Charan_Donthi
 *
 */
public class Category {
	public String categoryName;
	Set<Category> subCategories=new LinkedHashSet<Category>();
	Set<Product> productsInCategory=new LinkedHashSet<Product>();
	
	public Category(String categoryName) {
		this.categoryName=categoryName;
	}

}

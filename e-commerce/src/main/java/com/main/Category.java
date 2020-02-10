
package com.main;

import java.util.Set;
import java.util.LinkedHashSet;


public class Category {
	public String categoryName;
	private Set<Category> subCategories=new LinkedHashSet<>();
	private Set<Product> products=new LinkedHashSet<>();
	
	public Category(String categoryName) {
		this.categoryName=categoryName;
	}
	
	public Set<Category> getSubCategories(){
		return subCategories;
	}
	
	public Set<Product> getProducts(){
		return products;
	}
	
	public boolean addSubCategory(Category subCategory) {
		return subCategories.add(subCategory);
	}
	
	public boolean addProduct(Product product) {
		return products.add(product);
	}
	
	public boolean addSubCategories(Set<Category> subcategories) {
		return this.subCategories.addAll(subcategories);
	}
	
	public boolean addProducts(Set<Product> products) {
		return this.products.addAll(products);
	}

}

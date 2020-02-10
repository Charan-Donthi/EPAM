package com.main;


public class Product{
	
	public String productName;
	public double price=0;
	public int quantity=0;
	
	public Product(String productName) {
		this.productName=productName;
		EpamTree.allProducts.put(productName, this);
	}
	
	public Product(String productName,double price,int quantity) {
		this.productName=productName;
		this.price=price;
		this.quantity=quantity;
		EpamTree.allProducts.put(productName, this);
	}
	

	public Product(Product product) {
		this.productName=product.productName;
		this.price=product.price;
		this.quantity=1;
	} 
	

}

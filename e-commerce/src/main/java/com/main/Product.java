package com.main;


public class Product{
	
	private String productName;
	private double price=0;
	private int quantity=0;
	
	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product(String productName) {
		this.productName=productName;
		EpamTree.getAllProducts().put(productName, this);
	}
	
	public Product(String productName,double price,int quantity) {
		this.productName=productName;
		this.setPrice(price);
		this.setQuantity(quantity);
		EpamTree.getAllProducts().put(productName, this);
	}
	

	public Product(Product product) {
		this.productName=product.productName;
		this.setPrice(product.getPrice());
		this.setQuantity(1);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	} 
	

}

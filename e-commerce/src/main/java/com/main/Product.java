package com.main;


public class Product implements Cloneable{
	
	public String productName;
	public double price=0;
	public int quantity=0;
	
	public Product(String productName) {
		this.productName=productName;
	}
	
	public boolean isAvailable() {
		if(quantity>0) return true;
		return false;
	}
	
	public Object clone() throws CloneNotSupportedException { 
		return super.clone(); 
	} 
	

}

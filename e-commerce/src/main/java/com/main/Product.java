/**
 * 
 */

package com.main;

/**
 * @author Charan_Donthi
 *
 */
public class Product {
	
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
	

}

/**
 * 
 */
package com.main;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Charan_Donthi
 *
 */
public class Cart {
	Set<Product> productsInCart=new LinkedHashSet<Product>();
	
	public double totalPrice=0;
	
	
	
	public boolean addProduct(Product product) {
		if(productsInCart.add(product)) return true;
		return false;
	}
	
	
	public void showCart() {
		
		if(productsInCart.isEmpty()) {
			System.out.println("You have an Empty Cart");
			return;
		}
		for(Product product:productsInCart)
		{
			System.out.println(product.productName + "---" + product.quantity + "---" + product.price);
			totalPrice+=product.price;
		}
		System.out.println("TotalPrice="+totalPrice);
		
		cartMenu();
	}
	
	
	
	
	public void cartMenu()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("\n1.Remove\\Change Quantity of product\n2.Confirm Order\n3.checkout\n4.exit");
		int choice=input.nextInt();
		
		switch(choice)
		{
		case 1:
			removingAndChangingQuantity();
			break;
		case 2:
			System.out.println("Order confirmed");
			System.out.println("Your Products are on its way");
			System.exit(0);
			break;
		case 3:
			System.out.println("Checked out");
			break;
		case 4:
			System.exit(0);
		default:
			System.out.println("Choose valid option");	
		}
		
	}
	
	
	
	public void removingAndChangingQuantity() {
		Scanner input= new Scanner(System.in);
		System.out.println("\nSelect Product from Cart");
		String productName=input.next();
		Product product=searchProductByName(productName);
		//check that choice has correct string 
		System.out.println("\n1.Remove Product\n2.Change Quantity\n3.checkout");
		int choice=input.nextInt();
		switch(choice)
		{
		case 1:
			if(removeProduct(product)) {
				System.out.println("Product removed from cart");
			}else {System.out.println("Error in removing");}
			break;
		case 2:
			changeQuantity(product);
			System.out.println("Quantity changed");
			break;
		case 3:
			System.out.println("Checked out");
			break;
		default:
			System.out.println("Enter valid Option");
		}
	
	}
	
	
	
	public Product searchProductByName(String productName) {
		
		for(Product product:productsInCart) {
			if(product.productName.equals(productName)) return product;
		}
		//throw product not found exception
		return null;
	}
	
	
	
	public boolean removeProduct(Product product) {
		return productsInCart.remove(product);	
	}
	
	
	
	public void changeQuantity(Product product) {
		System.out.println("Ordered Quantity="+product.quantity);
		System.out.println("Change it to=");
		Scanner input= new Scanner(System.in);
		int newQuantity=input.nextInt();
		if(newQuantity<=0) {
			System.out.println("Enter valid Quantity");
			changeQuantity(product);
		}
		product.quantity=newQuantity;
		System.out.println(product.quantity);
		product.price*=product.quantity;
		
		System.out.println(product.price);
	}
	
	
}

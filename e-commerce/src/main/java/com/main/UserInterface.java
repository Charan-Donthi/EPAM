/**
 * 
 */
package com.main;

import java.util.Scanner;
import java.lang.Exception;

/**
 * @author Charan_Donthi
 *
 */
public class UserInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		userInterface();
		

	}
	
	
	
	public static void userInterface() {
		System.out.println("Here we go.......");
		System.out.println("Welcome to Epam e-commerce");
		int choice=0;
		
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.println("Who are you");
			System.out.println("1.Admin\n2.Customer\n3.exit");
			System.out.println("Chose option:");
			try {
			choice=input.nextInt();
			}catch(Exception e) {
				System.out.println(e.toString()+"\nEnter valid input");
			}
			switch(choice)
			{
				case 1:
					adminInterface();
					break;
				case 2:
					System.out.println("In Customer");
					customerInterface();
					break;
				case 3:
					System.out.println("exited");
					System.exit(0);
					break;
				default:
					System.out.println("Give Valid option");
				
			}
		}
	}
	
	
	
	public static void adminInterface() {
		
		System.out.println("In Admin");

		Scanner input; 
		int choice=0;
		
		while(true) {
			input= new Scanner(System.in);
			
			System.out.println("1.Check Stock\n2.Show Categories\n3.Add Category\n4.Add Product\n5.Check Out\n6.exit");
		
			try {
				choice=input.nextInt();
			}catch(Exception e) {
				System.out.println(e.toString()+"\nEnter valid input");
			}
		
			switch(choice)
			{
				case 1:
					//list the categories and items to show stock;
					System.out.println("Checking Stock......");
					break;
				case 2:
					System.out.println("Showing Categories.....");
					break;
				case 3:
					System.out.println("Adding Categories.....");
					break;
				case 4:
					System.out.println("Adding Product.....");
					break;
				case 5:
					System.out.println("Checked out from Admin");
					return;
				case 6:
					System.out.println("exited");
					System.exit(0);
					break;
				default:
					System.out.println("Give Valid option");
			
			}
		}
	}
	
	
	
	public static void customerInterface() {
		
		System.out.println("In Customer");
		
		
		//initialize and load database
		DataBase db=new DataBase();
		db.intializeCategories();
		db.intializeProducts();
		
		Cart yourCart=new Cart();

		Scanner input;
		int choice=0;
		
		while(true) {
			
			input= new Scanner(System.in);
			
			System.out.println("1.Show Categories\n2.Show Products\n3.Add To Cart\n4.Show Cart\n5.Check Out\n6.exit");
		
			try {
				choice=input.nextInt();
			}catch(Exception e) {
				System.out.println(e.toString()+"\nEnter valid input");
			}
		
			switch(choice)
			{
				case 1:
					//list the categories;
					System.out.println("Showing Categories.....");
					break;
				case 2:
					System.out.println("Showing Products.....");
					break;
				case 3:
					System.out.println("Added to Cart");
					break;
				case 4:
					System.out.println("Showing Cart....");
					yourCart.showCart();
					return;
				case 5:
					System.out.println("Checked out from Customer");
					return;
				case 6:
					System.out.println("exited");
					System.exit(0);
					break;

				default:
					System.out.println("Give Valid option");
			
			}
		}
		
	}
	
	
	


}

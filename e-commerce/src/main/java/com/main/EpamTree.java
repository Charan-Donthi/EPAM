package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.InputOutput.IO;




public class EpamTree {
	public static String user;
	public static List<Object> branch=new ArrayList<>();
	public static Map<String,Product> allProducts=new HashMap<>();
	public static boolean checkOutStatus=false;
	public static Cart yourCart;
	
	
	
	EpamTree(Category initialCategory) {
		branch.add(initialCategory);
	}
	
	
	public static void displayCurrentBranch(String path) {
		int pageWidth=100;
		System.out.print("******");
		System.out.print("User:"+user);
		for(int i=0;i<(pageWidth-path.length())/2;i++)	System.out.print("*");
		System.out.print(path);
		for(int i=0;i<(pageWidth-path.length())/2;i++)	System.out.print("*");
		System.out.println("");
	}
	
	
	
	public static String generatePath() {
		StringBuilder path=new StringBuilder("");
		for(Object field:branch) {
			if(isCategory(field))
				path.append("/"+((Category)field).categoryName);
			if(isProduct(field)) {
				path.append("/"+((Product)field).productName);
			}	
		}
		return path.toString();
	}
	
	
	
	public static boolean isProduct(Object o) {
		return o instanceof Product;
	}
	
	
	
	public static boolean isCategory(Object o) {
		return o instanceof Category;
	}
	
	
	public static String requestOption(){
		displayCurrentBranch(generatePath());
		System.out.print("Type name/path to go there Or Select option::::");
		return IO.readStringInput();
	}
	
	public static Object getCurrentObject() {
		return branch.toArray()[branch.size()-1];
	}
	
	
	
	public static void traverse(String input) {
		
		for(String singleInput:input.split("/")) {
			if(!traverseInBranch(singleInput)) {
				System.out.println("Incorrect Path");
			}
		}
		
	}
	
	
	public static boolean traverseInBranch(String input) {
		
		
		if(isCategory(getCurrentObject())) { 
			for(Category category:((Category)getCurrentObject()).getSubCategories()) {
				if(category.categoryName.equalsIgnoreCase(input)) {
					branch.add(category);
					return true;
				}
			}
			
			for(Product product:((Category)getCurrentObject()).getProducts()) {
				if(product.productName.equalsIgnoreCase(input)) {
					branch.add(product);
					return true;
				}
			}
		}
		

		
		return false;
		
	}
	

}

package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.inputoutput.IO;




public class EpamTree {
	
	private EpamTree(){
		
	}
	
	private static String user;
	

	private static List<Object> branch=new ArrayList<>();
	

	private static Map<String,Product> allProducts=new HashMap<>();
	

	private static boolean checkOutStatus=false;
	
	public static List<Object> getBranch() {
		return branch;
	}
	
	public static String getUser() {
		return user;
	}


	public static void setUser(String user) {
		EpamTree.user = user;
	}
	
	
	public static boolean isCheckOutStatus() {
		return checkOutStatus;
	}


	public static void setCheckOutStatus(boolean checkOutStatus) {
		EpamTree.checkOutStatus = checkOutStatus;
	}

	private static Cart yourCart;
	
	
	public static Cart getYourCart() {
		return yourCart;
	}


	public static void setYourCart(Cart yourCart) {
		EpamTree.yourCart = yourCart;
	}

	static final Logger logger=LogManager.getLogger(EpamTree.class);
	
	
	
	public static void setInitialCategory(Category initialCategory) {
		branch.add(initialCategory);
	}
	
	
	public static void displayCurrentBranch(String path) {
		int pageWidth=100;
		StringBuilder line=new StringBuilder();
		for(int i=0;i<(pageWidth-path.length())/2;i++)	line.append("*");
		logger.info("******User:{}{}{}{}",user,line,path,line);
	}
	
	
	
	public static String generatePath() {
		StringBuilder path=new StringBuilder("");
		for(Object field:branch) {
			if(isCategory(field))
				path.append("/"+((Category)field).getCategoryName());
			if(isProduct(field)) {
				path.append("/"+((Product)field).getProductName());
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
		logger.info("Type name/path to go there Or Select option::::");
		return IO.readStringInput();
	}
	
	public static Object getCurrentObject() {
		return branch.toArray()[branch.size()-1];
	}
	
	
	
	public static void traverse(String input) {
		
		for(String singleInput:input.split("/")) {
			if(!traverseInBranch(singleInput)) {
				logger.warn("Incorrect Path");
			}
		}
		
	}
	
	
	public static boolean traverseInBranch(String input) {
		
		
		if(isCategory(getCurrentObject())) { 
			for(Category category:((Category)getCurrentObject()).getSubCategories()) {
				if(category.getCategoryName().equalsIgnoreCase(input)) {
					branch.add(category);
					return true;
				}
			}
			
			for(Product product:((Category)getCurrentObject()).getProducts()) {
				if(product.getProductName().equalsIgnoreCase(input)) {
					branch.add(product);
					return true;
				}
			}
		}
		

		
		return false;
		
	}

	public static Map<String,Product> getAllProducts() {
		return allProducts;
	}
	

}

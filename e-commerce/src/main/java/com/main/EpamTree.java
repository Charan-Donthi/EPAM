package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class EpamTree {
	public static Object user=null;
	public static List<Object> branch=new ArrayList<Object>();
	public static Map<String,Product> allProducts=new HashMap<String,Product>();
	public static boolean checkOutStatus=false;
	
	
	
	public EpamTree(Category initialCategory) {
		branch.add(initialCategory);
	}
	
	
	public static void showCurrentBranch(String path) {
		int pageWidth=100;
		for(int i=0;i<(pageWidth-path.length())/2;i++)	System.out.print("*");
		System.out.print(path);
		for(int i=0;i<(pageWidth-path.length())/2;i++)	System.out.print("*");
		System.out.println("");
	}
	
	
	
	public static String generatePath() {
		String path="";
		for(Object field:branch) {
			if(isCategory(field))
				path+="/"+((Category)field).categoryName;
			if(isProduct(field)) {
				path+="/"+((Product)field).productName;
			}	
		}
		return path;
	}
	
	
	
	public static boolean isProduct(Object o) {
		return o instanceof Product;
	}
	
	
	
	public static boolean isCategory(Object o) {
		return o instanceof Category;
	}
	
	
	public static void requestOption(){
		EpamTree.showCurrentBranch(generatePath());
		System.out.print("Traverse Or Select option::::");
	}
	
	public static Object getCurrentObject() {
		return EpamTree.branch.toArray()[EpamTree.branch.size()-1];
	}
	
	
	
	public static void traverse(String input) {
		
		for(String singleInput:input.split("/")) {
			if(!traverseInBranch(singleInput)) {
				System.out.println("Incorrect Path");
			}
		}
		
	}
	
	
	public static boolean traverseInBranch(String input) {
		
		if(EpamTree.isCategory(EpamTree.getCurrentObject())) { 
			for(Category category:((Category)EpamTree.getCurrentObject()).subCategories) {
				if(category.categoryName.equalsIgnoreCase(input)) {
					EpamTree.branch.add(category);
					return true;
				}
			}
			
			for(Product product:((Category)EpamTree.getCurrentObject()).productsInCategory) {
				if(product.productName.equalsIgnoreCase(input)) {
					EpamTree.branch.add(product);
					return true;
				}
			}
		}
		return false;
		
	}
	

}

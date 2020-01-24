package com.main;

import java.util.ArrayList;
import java.util.List;

public class EpamTree {
	public static List<Object> branch=new ArrayList<Object>();
	
	public EpamTree(Category initialCategory) {
		branch.add(initialCategory);
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
	

}

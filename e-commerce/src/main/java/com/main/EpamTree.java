package com.main;

import java.util.ArrayList;
import java.util.List;

public class EpamTree {
	public static List<Object> branch=new ArrayList<Object>();
	
	public EpamTree(Category initialCategory) {
		branch.add(initialCategory);
	}
	
	
	public static void showCurrentBranch() {
		int pageWidth=100;
		String path=generatePath();
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
		EpamTree.showCurrentBranch();
		System.out.print("Select Option:::::");
	}
	
	public static Object getCurrentObject() {
		return EpamTree.branch.get(EpamTree.branch.size()-1);
	}
	

}

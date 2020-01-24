package com.main;

import com.appInterface.UserInterface;

public class WorkSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase db=new DataBase();
		db.intializeCategories();
		db.intializeProducts();
		
		new EpamTree(db.epam);
		EpamTree.branch.add(db.acer);
		
		System.out.println(EpamTree.generatePath());
		
		
		UserInterface user=new UserInterface();
		user.displayUserMenu();
		
	}

}

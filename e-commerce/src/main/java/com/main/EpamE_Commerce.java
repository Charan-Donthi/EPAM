package com.main;

import com.dataBase.*;

import com.appInterface.UserInterface;


public class EpamE_Commerce {

	public static void main(String[] args) {
		
		DataBase db=new DataBase();
		db.intializeCategories();
		db.intializeProducts();
		
		new EpamTree(db.epam);
		
		EpamTree.displayCurrentBranch(EpamTree.generatePath());
		
		
		UserInterface user=new UserInterface();
		user.displayMenu();
		
	}

}

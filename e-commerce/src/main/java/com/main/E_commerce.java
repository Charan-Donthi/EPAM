package com.main;

import com.appInterface.UserInterface;

public class E_commerce {

	public static void main(String[] args) {
		
		DataBase db=new DataBase();
		db.intializeCategories();
		db.intializeProducts();
		
		new EpamTree(db.epam);
		
		EpamTree.showCurrentBranch(EpamTree.generatePath());
		UserInterface user=new UserInterface();
		user.displayUserMenu();
		
	}

}

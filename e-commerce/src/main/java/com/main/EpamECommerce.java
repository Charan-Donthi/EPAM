package com.main;

import com.appinterface.UserInterface;
import com.database.*;


public class EpamECommerce {

	public static void main(String[] args) {
		
		DataBase db=new DataBase();
		db.intializeCategories();
		db.intializeProducts();
		
		EpamTree.setInitialCategory(db.getEpam());
		
		EpamTree.displayCurrentBranch(EpamTree.generatePath());
		
		
		UserInterface user=new UserInterface();
		user.displayMenu();
		
	}

}

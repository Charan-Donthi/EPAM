package com.main;

import com.IO.IO;
import com.appInterface.UserInterface;

public class WorkSpace {

	public static void main(String[] args) {
		
		DataBase db=new DataBase();
		db.intializeCategories();
		db.intializeProducts();
		
		new EpamTree(db.epam);
		
		while(IO.readStringInput().equals("go")) {
		EpamTree.showCurrentBranch();
		
		System.out.print("Go to:::::");
		String objectName=IO.readStringInput();
		
		if(EpamTree.isCategory(EpamTree.getCurrentObject())) {
			for(Category category:((Category)EpamTree.getCurrentObject()).subCategories) {
				if(category.categoryName.equalsIgnoreCase(objectName)) {
					EpamTree.branch.add(category);
					break;
				}
			}
			
			for(Product product:((Category)EpamTree.getCurrentObject()).productsInCategory) {
				if(product.productName.equalsIgnoreCase(objectName)) {
					EpamTree.branch.add(product);
				}
			}
		}
		
		EpamTree.showCurrentBranch();
		}
		//UserInterface user=new UserInterface();
		//user.displayUserMenu();
		
	}

}

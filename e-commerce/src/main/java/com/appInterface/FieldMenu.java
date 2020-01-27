
package com.appInterface;

import com.main.EpamTree;

public class FieldMenu {
	
	public static void currentFieldMenu() {
		Object currentObject=EpamTree.getCurrentObject();
		if(EpamTree.isCategory(currentObject)) {
			if(EpamTree.user instanceof AdminInterface) {
				((AdminInterface)EpamTree.user).categoryMenu(currentObject);
			}
			if(EpamTree.user instanceof CustomerInterface) {
				((CustomerInterface)EpamTree.user).categoryMenu(currentObject);
			}
		}
		
		if(EpamTree.isProduct(currentObject)) {
			if(EpamTree.user instanceof AdminInterface) {
				((AdminInterface)EpamTree.user).productMenu(currentObject);
			}
			if(EpamTree.user instanceof CustomerInterface) {
				((CustomerInterface)EpamTree.user).productMenu(currentObject);
			}
		}
		
	}

}

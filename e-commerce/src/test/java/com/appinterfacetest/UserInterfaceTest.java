package com.appinterfacetest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.appinterface.UserInterface;
import com.database.DataBase;
import com.main.EpamTree;

public class UserInterfaceTest {
	
	UserInterface user=new UserInterface();

	@Test
	public void objectCreationTest() {
		assertNotNull(user);
	}
	
	@Test
	public void checkOutTest() {
		DataBase db=new DataBase();
		db.intializeCategories();
		db.intializeProducts();
		
		
		EpamTree.setInitialCategory(db.getEpam());
		EpamTree.traverse("electronics");
		
		user.checkOut();
		assertEquals(false,EpamTree.isCheckOutStatus());
		
		user.checkOut();
		assertEquals(true,EpamTree.isCheckOutStatus());
		
	}

}

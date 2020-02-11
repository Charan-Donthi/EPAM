package com.appinterfacetest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.appinterface.AdminInterface;

public class AdminInterfaceTest {
	
	AdminInterface admin=new AdminInterface("User name");

	@Test
	public void ObjectCreationTest() {
		assertNotNull(admin);
	}
	
	
	//test case not passed initially but passed after changing string to string.trim() in isNumeric method
	@Test
	public void validateIsNumeric() {
		Boolean[] booleans=new Boolean[] {true,true,true,true,true,true,false,false};
		Boolean[] actualBooleans=new Boolean[booleans.length];
		String[] inputs=new String[] {"120","00","3 ","-10","-0"," -1","dfjhbsa","  "};
		
		for(int i=0;i<actualBooleans.length;i++) {
			actualBooleans[i]=admin.isNumeric(inputs[i]);
		}
		
		assertArrayEquals(booleans, actualBooleans);
	}
	
	

}

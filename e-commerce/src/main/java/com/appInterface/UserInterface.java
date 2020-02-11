package com.appinterface;

import java.util.InputMismatchException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.inputoutput.*;
import com.main.EpamTree;



public class UserInterface  {
	
	 protected String user="user";
	
	 final Logger logger=(Logger) LogManager.getLogger(UserInterface.class);
	
	
	public void displayMenu() {
		
		
		logger.info("--------------\n1.Admin\n2.Customer\n3.Exit");
		EpamTree.displayCurrentBranch(EpamTree.generatePath());
		logger.info("Select option:::::");
		
		try {
		switch(IO.readIntInput()) {
		case 1:
			UserInterface admin=new AdminInterface("admin");
			EpamTree.setUser(admin.user);
			admin.displayMenu();
			EpamTree.setUser(user);
			break;
		case 2:
			UserInterface customer=new CustomerInterface("customer");
			EpamTree.setUser(customer.user);
			customer.displayMenu();
			EpamTree.setUser(user);
			break;
		case 3:
			return;
		default:
			logger.info("Select from given Options");	
		}}catch(InputMismatchException e) {
			logger.warn("Invalid input");
			return;
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			return;
		}
		
		displayMenu();
	}
	
	
	
	public void checkOut(){
		if(EpamTree.getBranch().size()>=2) {
		EpamTree.getBranch().remove(EpamTree.getBranch().size()-1);	}
		else{
		EpamTree.setCheckOutStatus(true);
		}
	}
	

	public void exit() {
		System.exit(0);
	}
	


}

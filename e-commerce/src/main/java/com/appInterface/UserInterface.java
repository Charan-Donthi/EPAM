package com.appInterface;

import java.util.InputMismatchException;

import com.InputOutput.*;
import com.main.EpamTree;



public class UserInterface  {
	
	public String user="user";
	
	
	public void displayMenu() {
		
		
		System.out.println("--------------\n1.Admin\n2.Customer\n3.Exit");
		EpamTree.displayCurrentBranch(EpamTree.generatePath());
		System.out.print("Select option:::::");
		
		try {
		switch(IO.readIntInput()) {
		case 1:
			UserInterface admin=new AdminInterface("admin");
			EpamTree.user=admin.user;
			admin.displayMenu();
			EpamTree.user=user;
			break;
		case 2:
			UserInterface customer=new CustomerInterface("customer");
			EpamTree.user=customer.user;
			customer.displayMenu();
			EpamTree.user=user;
			break;
		case 3:
			return;
		default:
			System.out.println("Select from given Options");	
		}}catch(InputMismatchException e) {
			System.out.println("Invalid input");
			return;
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return;
		}
		
		displayMenu();
	}
	
	
	
	public void checkOut(){
		if(!(EpamTree.branch.size()==1)) {
		EpamTree.branch.remove(EpamTree.branch.size()-1);	}
		else{
		EpamTree.checkOutStatus=true;
		}
	}
	

	public void Exit() {
		System.exit(0);
	}
	


}

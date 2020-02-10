package com.options;

import com.main.EpamTree;

public class CheckOut extends Option{
	
	private static Option instance;
	
	public CheckOut(String newOptionName) {
		setOptionName(newOptionName);
	}
	
	public static Option getInstance() {
		if(instance==null) {
			instance=new CheckOut("Check Out");
			return instance;
		}
		return instance;
	}
	
	public void function() {
		if(EpamTree.branch.size()!=1) {
			EpamTree.branch.remove(EpamTree.branch.size()-1);	}
			else{
			EpamTree.checkOutStatus=true;
			}
	}
}

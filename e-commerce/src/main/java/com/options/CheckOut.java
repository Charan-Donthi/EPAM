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
	
	@Override
	public void function() {
		if(EpamTree.getBranch().size()!=1) {
			EpamTree.getBranch().remove(EpamTree.getBranch().size()-1);	}
			else{
			EpamTree.setCheckOutStatus(true);
			}
	}
}

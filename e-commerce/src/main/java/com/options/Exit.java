package com.options;

public class Exit extends Option{
	
	private static Option instance;
	
	private Exit(String newOptionName) {
		setOptionName(newOptionName);
	}
	
	public static Option getInstance() {
		if(instance==null) {
			instance=new Exit("Exit");
			return instance;
		}
		return instance;
	}
	
	@Override
	public void function() {
		System.exit(0);
	}
}

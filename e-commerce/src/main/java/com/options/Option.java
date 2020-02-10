package com.options;

import Console.ConsoleFeatures.*;

public abstract class Option {
	private String optionName="Option";
	String getOptionName() {return optionName;}
	public void setOptionName(String newOptionName) {optionName=newOptionName;}
	public void function() {
		Console.println(getOptionName()+" option yet not implemented");
	}
}

package com.options;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public abstract class Option {
	final Logger logger=(Logger) LogManager.getLogger(Option.class);
	private String optionName="Option";
	String getOptionName() {return optionName;}
	public void setOptionName(String newOptionName) {optionName=newOptionName;}
	public void function() {
		logger.warn(getOptionName()+" option yet not implemented");
	}
}

package com.epam.dev_ecommerce.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private Config() {
		
	}
	
	private static Properties properties;
	
	public static Properties getProperties() throws IOException{
		
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/com/epam/dev_ecommerce/utilityfiles/webdriver.properties");
			properties=new Properties();
			properties.load(file);
			return properties;
	}

}

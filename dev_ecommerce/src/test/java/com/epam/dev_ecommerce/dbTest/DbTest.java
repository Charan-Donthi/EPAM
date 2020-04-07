package com.epam.dev_ecommerce.dbTest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import org.testng.annotations.BeforeClass;


public class DbTest {
	
	Connection connection;
	
	@BeforeClass
	public void connectToDb() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		Properties properties=new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/com/epam/dev_ecommerce/utilities/db_connection_credentials.properties"));
		
		String URL=properties.getProperty("URL");
		String USER=properties.getProperty("User");
		Scanner input = new Scanner(System.in);
		
			System.out.println("Enter the database password");
			String PASSWORD=input.nextLine();
			connection=DriverManager.getConnection(URL, USER, PASSWORD);
		
		
	}
	
	

}

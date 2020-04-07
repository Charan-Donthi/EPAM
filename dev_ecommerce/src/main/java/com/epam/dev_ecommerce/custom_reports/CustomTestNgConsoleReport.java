package com.epam.dev_ecommerce.custom_reports;


import java.util.Collection;
import java.util.List;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;
import java.util.Map;
import java.util.Set;


public class CustomTestNgConsoleReport implements IReporter{
	
	public  void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		    
		for(ISuite suit:suites) {       
			Map<String,ISuiteResult> suitResult=suit.getResults();
			
			Set<String> tests=suitResult.keySet();
			
			for(String test:tests) {
				ITestContext testContext=suitResult.get(test).getTestContext();
				
				IResultMap failedTest = testContext.getFailedTests();
				
				
				
				Collection<ITestNGMethod> failedMethods = failedTest.getAllMethods();
				
				System.out.println("------Failed Test Case-----");
				
				for(ITestNGMethod imd : failedMethods){
					
					System.out.println("FAILED:"+imd.getMethodName()+"  FOR ARG--"+testContext.getAttributeNames());
					
					
				}
				
				
				IResultMap passedTest = testContext.getPassedTests();
				
				
				Collection<ITestNGMethod> passedMethods = passedTest.getAllMethods();
				
				System.out.println("------Passed Test Case-----");
				
				for(ITestNGMethod imd1 : passedMethods){
					
					System.out.println("PASSED:"+imd1.getMethodName());
					
					
					
				}
			}
			
		}
	}

}

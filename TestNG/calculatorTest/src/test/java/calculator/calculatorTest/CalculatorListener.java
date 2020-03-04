package calculator.calculatorTest;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CalculatorListener implements ITestListener{
	
	public  void onTestStart(ITestResult result) {
	    System.out.println(result.getName()+"----Started");
	  }


	 public  void onTestSuccess(ITestResult result) {
		 System.out.println(result.getName()+"---Success");
	  }

	 public  void onTestFailure(ITestResult result) {
		 System.out.println(result.getName()+"---Failed");
	  }

	 
	  public  void onTestSkipped(ITestResult result) {
		  System.out.println(result.getName() + "--is skipped");
	  }
	  



}

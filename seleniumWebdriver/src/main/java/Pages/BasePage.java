package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	@FindBy(xpath="//*[text()='Car Rentals' or text()='Rental cars' ]//parent::a")
	protected WebElement CarRentals;
	
	@FindBy(xpath="//*[text()='Flights']//parent::a")
	protected WebElement Flights;
	


	public void closeDriver() {
		driver.close();
	}
	
	public void clickWebElement(int noOfClicks, WebElement element) {
		if(noOfClicks==0) return;
		try {
			Thread.sleep(100);
			element.click();
			clickWebElement(--noOfClicks,element);
		} catch (InterruptedException e) {
			return;
		}
		
	}
	
	public WebElement getCarRentals() {
		return CarRentals;
	}
	
	public WebElement getFlights() {
		return Flights;
	}
	
	public void slowSend(WebElement textField,String charSequence) throws InterruptedException {
		textField.click();
		for(char character:charSequence.toCharArray()) {
			Thread.sleep(50);
			textField.sendKeys(""+character);
		}
	}
	

}

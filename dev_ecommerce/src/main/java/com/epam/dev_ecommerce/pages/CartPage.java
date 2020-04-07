package com.epam.dev_ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='CheckOut']")
	protected WebElement checkOut;
	
	@FindBy(xpath="//*[@name='totalCartSum']")
	protected WebElement totalCartSum;
	
	public double getTotalCartSum() {
		return Double.parseDouble(totalCartSum.getText());
	}

	public void decrementProductTo(String productName,int quantity) throws InterruptedException {
		int selectedQuantity=this.getSelectedQuantity(productName);
		
		int noOfClicks=selectedQuantity-quantity;
		
		if(noOfClicks>=0) {
			while(noOfClicks-->0) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//*[text()=\""+productName+"\"]//parent::tr//input[@formaction='\\decrement']")).click();
			}
		}
	}
	
	public void incrementProductTo(String productName,int quantity) throws InterruptedException {
		int selectedQuantity=this.getSelectedQuantity(productName);
		
		int noOfClicks=selectedQuantity-quantity;
		
		if(noOfClicks>=0) {
			while(noOfClicks-->0) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//*[text()=\""+productName+"\"]//parent::tr//input[@formaction='\\increment']")).click();
			}
		}
	}
	
	public void checkOut() {
		this.checkOut.click();
	}
	
	
	public int getSelectedQuantity(String productName) {
		return Integer.parseInt(driver.findElement(By.xpath("//*[text()=\""+productName+"\"]/following-sibling::td[2]")).getText().trim());
	}
	
	
	public void removeProduct(String productName) {
		driver.findElement(By.xpath("//*[text()=\""+productName+"\"]//parent::tr//input[@formaction='\\removeItem']")).click();
	}
	

	
	

}

package com.epam.dev_ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartMessagePage extends BasePage{

	public CartMessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='ViewCart']")
	protected WebElement ViewCart;

	
	@FindBy(xpath="//button[text()='Checkout']")
	protected WebElement checkOut;
	
	public void viewCart() {
		ViewCart.click();
	}
	
	public void checkOut() {
		checkOut.click();
	}
	
		

}

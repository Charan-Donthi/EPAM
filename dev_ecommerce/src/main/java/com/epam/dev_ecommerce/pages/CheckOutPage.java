package com.epam.dev_ecommerce.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePage{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[text()='Keep Shopping!']")
	protected WebElement keepShopping;
	
	public void keepShopping() {
		this.keepShopping.click();
	}
	
	
	

}

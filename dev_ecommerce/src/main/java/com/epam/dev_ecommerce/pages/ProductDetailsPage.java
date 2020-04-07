package com.epam.dev_ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectQuantity(int quantity) {
		driver.findElement(By.xpath("//input[@id=\"desiredQuantity1\"]")).sendKeys(""+quantity);
	}
	
	
	public void addToCart() {
		driver.findElement(By.xpath("//button[@id=\"addToCart\"]")).click();
	}
	
	
	

}

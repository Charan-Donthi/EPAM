package com.epam.dev_ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage{
	
	ProductDetailsPage productdetails;

	public ProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	public ProductDetailsPage selectProduct(String productName) {
		driver.findElement(By.xpath("//div[@class=\"productItems\"]//*[contains(text(),\""+productName+"\")]//parent::div//*[text()='View Details']//parent::button")).click();
		if(this.productdetails==null)
			return productdetails=new ProductDetailsPage(driver);
			else return this.productdetails;
	}

}

package com.epam.dev_ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SubCategoriesPage extends BasePage{
	
	ProductsPage productspage;

	public SubCategoriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	public ProductsPage selectsubCategory(String subcategoryName) {
		driver.findElement(By.xpath("//*[contains(text(),\""+subcategoryName+"\")]//parent::button")).click();
		if(this.productspage==null) {
			 productspage=new ProductsPage(driver);
		}
		return productspage;
	}

}

package com.epam.dev_ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage extends BasePage{
	
	SubCategoriesPage subcategorypage;

	public CategoriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public SubCategoriesPage selectCategory(String categoryName) {
		driver.findElement(By.xpath("//*[text()=\""+categoryName+"\"]/parent::button")).click();	
		if(this.subcategorypage==null)
			return subcategorypage=new SubCategoriesPage(driver);
			else return this.subcategorypage;
	}

}

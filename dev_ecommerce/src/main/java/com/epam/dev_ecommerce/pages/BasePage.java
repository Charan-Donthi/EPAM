package com.epam.dev_ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
	
	WebDriver driver;
	CategoriesPage categoriesPage=null;
	HomePage homepage=null;
	CartPage cartpage=null;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@FindBy(xpath="//div[@class='navbar']//a[contains(text(),'Home')]")
	protected WebElement HomePage;
	
	@FindBy(xpath="//div[@class='navbar']//a[@href='\\category']")
	protected WebElement CategoriesPage;
	
	@FindBy(xpath="//div[@class='navbar']//a[@href='\\cart']")
	protected WebElement CartPage;
	
	public HomePage homePage() {
		this.HomePage.click();
		if(this.homepage==null)
			return new HomePage(driver);
			else return this.homepage;
	}
	
	public CategoriesPage goTocategoriesPage() {
		this.CategoriesPage.click();
		if(this.categoriesPage==null)
		return categoriesPage=new CategoriesPage(driver);
		else return this.categoriesPage;
	}
	
	public CartPage cartPage() {
		this.CartPage.click();
		if(this.cartpage==null)
			return cartpage=new CartPage(driver);
			else return this.cartpage;
	}
	
	
	
	

}

package com.epam.dev_ecommerce.tests;




import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.dev_ecommerce.Exceptions.DriverNotFoundException;
import com.epam.dev_ecommerce.pages.CartPage;
import com.epam.dev_ecommerce.pages.CategoriesPage;
import com.epam.dev_ecommerce.pages.CheckOutPage;
import com.epam.dev_ecommerce.pages.HomePage;
import com.epam.dev_ecommerce.pages.ProductDetailsPage;
import com.epam.dev_ecommerce.pages.ProductsPage;
import com.epam.dev_ecommerce.pages.SubCategoriesPage;
import com.epam.dev_ecommerce.selenuim_webdriver.WebDriverFactory;


public class EcommerceTest {
	
	protected WebDriver driver;
	protected HomePage home;
	
	
	@BeforeClass
	public void openBrowser(String browser) throws DriverNotFoundException {
		driver=WebDriverFactory.getDriver(browser);
		
	}
	
	@BeforeClass
	public void openEcommerceApplication() {
		driver.get("http://10.71.8.199:8080/");
		home=new HomePage(driver);
	}
	
	
	
	
	@Test
	public void test() throws InterruptedException {
		
		
		
		
		CategoriesPage categoryPage=home.goTocategoriesPage();
		SubCategoriesPage subcategoriespage=categoryPage.selectCategory("Electronics");
		ProductsPage productspage=subcategoriespage.selectsubCategory("TV");
		ProductDetailsPage details=productspage.selectProduct("vbncg");
		details.selectQuantity(20);
		details.addToCart();
		CartPage cartpage=details.cartPage();
		
		Thread.sleep(2000);
		cartpage.removeProduct("vbncg");
		
		Thread.sleep(3000);
		
		cartpage.goTocategoriesPage();
		categoryPage.selectCategory("Books and Audible");
		subcategoriespage.selectsubCategory("Women's Wear");
		productspage.selectProduct("Sofa");
		details.selectQuantity(50);
		details.addToCart();
		details.cartPage();
		
		cartpage.goTocategoriesPage();
		categoryPage.selectCategory("Books and Audible");
		subcategoriespage.selectsubCategory("Women's Wear");
		productspage.selectProduct("Sofa");
		details.selectQuantity(20);
		details.addToCart();
		details.cartPage();
		
		cartpage.decrementProductTo("Sofa", 0);
		cartpage.checkOut();
		CheckOutPage checkoutpage=new CheckOutPage(driver);
		checkoutpage.keepShopping();
	
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}

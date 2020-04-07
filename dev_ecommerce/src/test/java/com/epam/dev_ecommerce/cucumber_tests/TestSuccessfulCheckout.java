package com.epam.dev_ecommerce.cucumber_tests;

import com.epam.dev_ecommerce.Exceptions.DriverNotFoundException;
import com.epam.dev_ecommerce.pages.CartPage;
import com.epam.dev_ecommerce.pages.CategoriesPage;
import com.epam.dev_ecommerce.pages.ProductDetailsPage;
import com.epam.dev_ecommerce.pages.ProductsPage;
import com.epam.dev_ecommerce.pages.SubCategoriesPage;
import com.epam.dev_ecommerce.tests.EcommerceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSuccessfulCheckout extends EcommerceTest{
	
	CategoriesPage categoryPage;
	SubCategoriesPage subcategoriespage;
	ProductsPage productspage;
	ProductDetailsPage details;
	CartPage cartpage;
	
	@Given("User launches {string} browser")
	public void user_launches_browser(String string) throws DriverNotFoundException, InterruptedException {
	   this.openBrowser(string);
	   Thread.sleep(1000);
	}

	@Given("User opens WebApplication")
	public void user_opens_WebApplication() throws InterruptedException {
		this.openEcommerceApplication();
		 Thread.sleep(1000);
	}

	@When("User navigates to Main menu")
	public void user_navigates_to_Main_menu() throws InterruptedException {
		categoryPage=home.goTocategoriesPage();
		 Thread.sleep(1000);
	}

	@When("User selects {string} category")
	public void user_selects_category(String string) throws InterruptedException {
		subcategoriespage=categoryPage.selectCategory(string);
		 Thread.sleep(1000);
	}

	@When("User navigates to subategory page")
	public void user_navigates_to_subategory_page() {
	    
	}

	@When("User selects {string} subcategory")
	public void user_selects_subcategory(String string) throws InterruptedException {
		productspage=subcategoriespage.selectsubCategory(string);
		 Thread.sleep(1000);
	}

	@When("User navigates to products page")
	public void user_navigates_to_products_page() {
	    
	}

	@When("User selects {string} product")
	public void user_selects_product(String string) throws InterruptedException {
		details=productspage.selectProduct(string);
		Thread.sleep(1000);
	}

	@When("User navigates to productdetails page")
	public void user_navigates_to_productdetails_page() {
	   
	}

	@When("User selects {int} quantity")
	public void user_selects_quantity(Integer int1) throws InterruptedException {
		details.selectQuantity(int1);
		Thread.sleep(1000);
	}

	@When("User adds product to cart")
	public void user_adds_product_to_cart() throws InterruptedException {
		details.addToCart();
		Thread.sleep(1000);
	}

	@When("User navigates to cart")
	public void user_navigates_to_cart() throws InterruptedException {
		cartpage=details.cartPage();
		Thread.sleep(1000);
	}
	
	@When("User checks out")
	public void user_checks_out() throws InterruptedException {
		cartpage.checkOut();
		Thread.sleep(1000);
	}

	@Then("Check whether status of checkout page is {string}")
	public void check_whether_status_of_checkout_page_is(String string) {

	}
	
	@When("User selects {string} product under {string} subcategory under {string} category")
	public void user_selects_product_under_subcategory_under_category(String string, String string2, String string3) {
	    details=home.goTocategoriesPage().selectCategory(string3).selectsubCategory(string2).selectProduct(string);
	}

	


}

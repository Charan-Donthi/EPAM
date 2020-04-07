package com.epam.dev_ecommerce.uitest;
import static org.testng.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.dev_ecommerce.Exceptions.DriverNotFoundException;
import com.epam.dev_ecommerce.objects.Category;
import com.epam.dev_ecommerce.objects.ProductDetails;
import com.epam.dev_ecommerce.objects.SubCategory;
import com.epam.dev_ecommerce.pages.CartPage;
import com.epam.dev_ecommerce.pages.CategoriesPage;
import com.epam.dev_ecommerce.pages.HomePage;
import com.epam.dev_ecommerce.pages.ProductDetailsPage;
import com.epam.dev_ecommerce.pages.ProductsPage;
import com.epam.dev_ecommerce.pages.SubCategoriesPage;
import com.epam.dev_ecommerce.selenuim_webdriver.WebDriverFactory;

public class UITest {
	
	protected WebDriver driver;
	protected HomePage home;

	CategoriesPage categoryPage;
	SubCategoriesPage subcategoriespage;
	ProductsPage productspage;
	ProductDetailsPage details;
	CartPage cartpage;
	
	
	@BeforeClass
	public void openBrowser() throws DriverNotFoundException {
		driver=WebDriverFactory.getDriver("chrome");
		
	}

	
	@Test
	public void checkCategories(List<Category> expectedCategories) throws DriverNotFoundException {
		
		List<Category> actualCategories = getAllCategoriesFromCategoriesPage();
		
		assertTrue(actualCategories.containsAll(expectedCategories) && actualCategories.size()==expectedCategories.size());
		
	}


	public List<Category> getAllCategoriesFromCategoriesPage() {
		
		driver.get("http://10.71.8.199:8080/category");
		
		List<WebElement> listOfInputWebElements=driver.findElements(By.xpath("//input[@name=\"category\"]"));
		
		List<Integer> listOfdistinctCategoryIds=listOfInputWebElements.stream().map(input->Integer.parseInt(input.getAttribute("value"))).collect(Collectors.toList());
		
		List<Category> actualCategories=listOfdistinctCategoryIds.stream()
																.map(categoryId->new Category()
																						.setCategoryId(categoryId)
																					     .setCategoryName(driver.findElement(By.xpath("//input[@name=\"category\" and @value=\""+categoryId+"\"]//preceding-sibling::button")).getText()))
																						.collect(Collectors.toList());
		return actualCategories;
	}
	
	
	@Test
	public void checkCategoriesUnderCategory(Category category,List<SubCategory> expectedSubCategories) {
		
		Map<Integer,String> mapcat=expectedSubCategories.stream().collect(Collectors.toMap(SubCategory::getSubCategoryId, SubCategory::getSubCategoryName));
		
		Map<Integer, String> map = getSubCategoriesOfACategory(category);
		
		assertThat(map,equalTo(mapcat));
	}


	public Map<Integer, String> getSubCategoriesOfACategory(Category category) {
		driver.get("http://10.71.8.199:8080/subcategories?category="+category.getCategoryId());
		
		List<WebElement> listOfInputWeblements=driver.findElements(By.xpath("//input[@name=\"subcategory\"]"));
		
		List<Integer> listOfdistinctSubCategoryIds=listOfInputWeblements.stream().map(input->Integer.parseInt(input.getAttribute("value"))).collect(Collectors.toList());

		Map<Integer,String> map=listOfdistinctSubCategoryIds.stream().collect(Collectors.toMap(subcategoryId->subcategoryId, subcategoryId->driver.findElement(By.xpath("//input[@name=\"subcategory\" and @value=\""+subcategoryId+"\"]//preceding-sibling::button")).getText()));
		return map;
	}
	
	
	@Test
	public void checkProductsUnderSubCategory(SubCategory subcategory,List<ProductDetails> expectedProducts) {
		
		Map<Integer,String> mapcat=expectedProducts.stream().collect(Collectors.toMap(ProductDetails::getProductId, ProductDetails::getProductName));
		
		Map<Integer, String> map = getProductsOfSubCategory(subcategory);
		
		
		assertThat(map,equalTo(mapcat));
	}


	public Map<Integer, String> getProductsOfSubCategory(SubCategory subcategory) {
		
		driver.get("http://10.71.8.199:8080/product?subcategory="+subcategory.getSubCategoryId());
		
		List<WebElement> listOfInputWeblements=driver.findElements(By.xpath("//input[@name=\"productOption\"]"));
		
		List<Integer> listOfdistinctProductIds=listOfInputWeblements.stream().map(input->Integer.parseInt(input.getAttribute("value"))).collect(Collectors.toList());
		
		
		Map<Integer,String> map=listOfdistinctProductIds.stream().collect(Collectors.toMap(productId->productId, productId->driver.findElement(By.xpath("//input[@name=\"productOption\" and @value='"+productId+"']//ancestor::div[@class='productItems']//h3")).getText()));
		return map;
	}
	
	
	@Test
	public void checkProductDetails(ProductDetails productdetails) throws InterruptedException {
		
		
		ProductDetails actualProduct=getProductDetails(productdetails);

		assertTrue(actualProduct.getProductId()==productdetails.getProductId()
				&& actualProduct.getProductName().equals(productdetails.getProductName())
				&& actualProduct.getProductPrice()==productdetails.getProductPrice()
				&& actualProduct.getProductQuantity()==productdetails.getProductQuantity());
		
		
	}
	
	
	public ProductDetails getProductDetails(ProductDetails productdetails) {
		driver.get("http://10.71.8.199:8080/product?subcategory="+productdetails.getSubCategoryId());
		
		productspage=new ProductsPage(driver);
		
		this.details=productspage.selectProduct(productdetails.getProductName());
		
		int productId=Integer.parseInt(driver.findElement(By.xpath("//input[@name='productId']")).getAttribute("value"));
		
		String productName=driver.findElement(By.xpath("//*[contains(text(),'Product Name')]//parent::td//following-sibling::td")).getText();
		
		double productPrice=Double.parseDouble(driver.findElement(By.xpath("//*[contains(text(),'Product Price')]//parent::td//following-sibling::td")).getText().substring(2));
		
		int productQuantity=Integer.parseInt(driver.findElement(By.xpath("//*[contains(text(),'Product Quantity')]//parent::td//following-sibling::td")).getText());
		
		return new ProductDetails().setProductId(productId).setProductName(productName).setProductPrice(productPrice).setProductQuantity(productQuantity);
	}
	
	
	@Test
	public void checkProductsInCart() {
		
		List<ProductDetails> expectedProducts=new ArrayList<ProductDetails>(Arrays.asList(new ProductDetails().setProductId(10).setProductName("Onida 2").setProductPrice(2000).setProductQuantity(1).setSubCategoryId(1),
																		  new ProductDetails().setProductId(12).setProductName("Sofa").setProductPrice(10000).setProductQuantity(21).setSubCategoryId(10)));
		expectedProducts.forEach(p->p.setSubCategoryId(0));
		List<ProductDetails> actualProducts = getAllCartProducts();
		
		assertTrue(actualProducts.equals(expectedProducts));
		
	}


	public List<ProductDetails> getAllCartProducts() {
		
		driver.get("http://10.71.8.199:8080/cart?");
		
		Set<Integer> productIds=driver.findElements(By.xpath("//input[@name='product_id']")).stream().map(element->Integer.parseInt(element.getAttribute("value"))).collect(Collectors.toSet());
		
		List<ProductDetails> actualProducts=productIds.stream().map(id->new ProductDetails()
																		.setProductId(id)
																		.setProductName(driver.findElement(By.xpath("//input[@name='product_id' and  @value='"+id+"']//ancestor::tr//td[1]")).getText())
																		.setProductPrice(Double.parseDouble(driver.findElement(By.xpath("//input[@name='product_id' and  @value='"+id+"']//ancestor::tr//td[2]")).getText().substring(1)))
																		.setProductQuantity(Integer.parseInt(driver.findElement(By.xpath("//input[@name='product_id' and  @value='"+id+"']//ancestor::tr//td[3]")).getText()))).collect(Collectors.toList());
		return actualProducts;
	}
	
	
	
}	
	


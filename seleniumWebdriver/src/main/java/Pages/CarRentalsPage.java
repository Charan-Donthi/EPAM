package Pages;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumWebdriver.InvalidDateException;

public class CarRentalsPage extends BasePage{
	
	
	String[] monthsarray={"January","February","March","April","May","June","July","August","September","October","November","Decemeber"};
	List<String> monthsName;
	
	public CarRentalsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		monthsName= Arrays.asList(monthsarray);
	}
	
	
	
	
	@FindBy(xpath="//input[@placeholder='Pickup location']")
	protected WebElement pickUpLocation;
	
	@FindBy(xpath="//input[@placeholder='Drop-off location']")
	protected WebElement dropOffLocation;
	
	@FindBy(xpath="//button[@class='sb-searchbox__button ']")
	protected WebElement carRentalsSearch;
	
	@FindBy(xpath="//div[@class='bui-radio']//label[@for='return-location-same']")
	protected WebElement returnLocationSame;
	
	@FindBy(xpath="//div[@class='bui-radio']//label[@for='return-location-different']")
	protected WebElement returnLocationDifferent;

	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkin']")
	protected WebElement PickUpDateandTimmings;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkin']//input[@name='checkin_month']")
	protected WebElement checkInMonth;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkin']//input[@name='checkin_monthday']")
	protected WebElement checkInDay;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkin']//input[@name='checkin_year']")
	protected WebElement checkInYear;
	
	public String[] getMonthsarray() {
		return monthsarray;
	}

	public List<String> getMonthsName() {
		return monthsName;
	}

	public WebElement getCheckInMonth() {
		return checkInMonth;
	}

	public WebElement getCheckInDay() {
		return checkInDay;
	}

	public WebElement getCheckInYear() {
		return checkInYear;
	}

	public WebElement getCheckOutMonth() {
		return checkOutMonth;
	}

	public WebElement getCheckOutDay() {
		return checkOutDay;
	}

	public WebElement getCheckOutYear() {
		return checkOutYear;
	}

	public List<WebElement> getMonths() {
		return months;
	}




	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkout']//input[@name='checkout_month']")
	protected WebElement checkOutMonth;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkout']//input[@name='checkout_monthday']")
	protected WebElement checkOutDay;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkout']//input[@name='checkout_year']")
	protected WebElement checkOutYear;
	
	public WebElement getPickUpDateandTimmings() {
		return PickUpDateandTimmings;
	}

	public WebElement getDropOffDateandTimmings() {
		return DropOffDateandTimmings;
	}


	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkout']")
	protected WebElement DropOffDateandTimmings;
	
	@FindBy(xpath="//input[@placeholder='Pickup location']//parent::label//following-sibling::ul[@aria-label='List of suggested destinations ']//li")
	protected List<WebElement> pickUpLocationSuggestedDestinations;
	
	@FindBy(xpath="//input[@placeholder='Drop-off location']//parent::label//following-sibling::ul[@aria-label='List of suggested destinations ']//li")
	protected List<WebElement> dropOffLocationSuggestedDestinations;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkin']//div[contains(@class,'c2-button c2-button-earlier')]")
	protected WebElement backwardMonthCheckInButton;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkin']//div[contains(@class,'c2-button c2-button-further')]")
	protected WebElement forwardMonthCheckInButton;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkout']//div[contains(@class,'c2-button c2-button-earlier')]")
	protected WebElement backwardMonthCheckOutButton;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkout']//div[contains(@class,'c2-button c2-button-further')]")
	protected WebElement forwardMonthCheckOutButton;
	
	@FindBy(xpath="//select[@name='checkinTime']")
	protected WebElement checkInTime;
	
	@FindBy(xpath="//select[@name='checkinTimeMinutes']")
	protected WebElement checkInTimeMinutes;
	
	@FindBy(xpath="//select[@name='checkoutTime']")
	protected WebElement checkOutTime;
	
	@FindBy(xpath="//select[@name='checkoutTimeMinutes']")
	protected WebElement checkOutTimeMinutes;
	
	@FindBy(xpath="//div[@class='xp__dates-inner xp__dates__checkin']//*[contains(@class,'monthname')]")
	protected List<WebElement> months;
		

	
	public WebElement getCheckOutTime() {
		return checkOutTime;
	}

	public WebElement getCheckOutTimeMinutes() {
		return checkOutTimeMinutes;
	}

	


	public WebElement getCheckInTimeMinutes() {
		return checkInTimeMinutes;
	}

	public WebElement getCheckInTime() {
		return checkInTime;
	}

	public WebElement getBackwardMonthCheckOutButton() {
		return backwardMonthCheckOutButton;
	}

	public WebElement getForwardMonthCheckOutButton() {
		return forwardMonthCheckOutButton;
	}

	public WebElement getBackwardMonthCheckInButton() {
		return backwardMonthCheckInButton;
	}

	public WebElement getForwardMonthCheckInButton() {
		return forwardMonthCheckInButton;
	}

	public List<WebElement> getPickUpLocationSuggestedDestinations() {
		return pickUpLocationSuggestedDestinations;
	}

	public List<WebElement> getDropOffLocationSuggestedDestinations() {
		return dropOffLocationSuggestedDestinations;
	}

	public WebElement getPickUpLocation() {
		return pickUpLocation;
	}

	public WebElement getDropOffLocation() {
		return dropOffLocation;
	}

	public WebElement getCarRentalsSearch() {
		return carRentalsSearch;
	}

	public WebElement getReturnLocationSame() {
		return returnLocationSame;
	}

	public WebElement getReturnLocationDifferent() {
		return returnLocationDifferent;
	}
	
	public void selectCheckInDate(String date) throws InvalidDateException {
		if(!this.checkDateFormat(date)) {
			throw new InvalidDateException("Date format Mismatch");
		}
		String[] dateFormat=date.split("/");
		int day=Integer.parseInt(dateFormat[0]);
		String month=monthsName.get(Integer.parseInt(dateFormat[1])-1);
		String year=dateFormat[2];
		this.moveToParticularDateInCalendar(Integer.parseInt(dateFormat[1]), Integer.parseInt(dateFormat[2]), this.backwardMonthCheckInButton, this.forwardMonthCheckInButton);
		driver.findElements(By.xpath("//div[@class='xp__dates-inner xp__dates__checkin']//*[text()='"+month+" "+year+"']//ancestor::table//tbody//td[contains(@class,'day')]")).get(day).click();
	}
	
	
	public void selectCheckOutDate(String date) throws InvalidDateException {
		if(!this.checkDateFormat(date)) {
			throw new InvalidDateException("Date format Mismatch");
		}
		String[] dateFormat=date.split("/");
		int day=Integer.parseInt(dateFormat[0]);
		String month=monthsName.get(Integer.parseInt(dateFormat[1])-1);
		String year=dateFormat[2];
		this.moveToParticularDateInCalendar(Integer.parseInt(dateFormat[1]), Integer.parseInt(dateFormat[2]), this.backwardMonthCheckOutButton, this.forwardMonthCheckOutButton);
		driver.findElements(By.xpath("//div[@class='xp__dates-inner xp__dates__checkout']//*[text()='"+month+" "+year+"']//ancestor::table//tbody//td[contains(@class,'day')]")).get(day).click();
	}
	
	
	public void moveToParticularDateInCalendar(int month,int year,WebElement prev,WebElement next) {
		String[] currentcalendar=this.months.get(0).getText().split(" ");
		System.out.println(this.months.get(0).getText());
		int currentmonth=monthsName.indexOf(currentcalendar[0])+1;
		System.out.println(currentmonth);
		System.out.println(currentcalendar[1]);
		int currentyear=Integer.parseInt(currentcalendar[1]);
		if(year-currentyear<0)
		{
			System.out.println(currentmonth+12-month+1);
			this.clickWebElement(currentmonth+12-month+1, prev);
		}else if(year-currentyear>0)
		{
			System.out.println(12-currentmonth+month-1);
			this.clickWebElement(12-currentmonth+month-1, next);
		}else {
			if(month-currentmonth<0)
			{		
				System.out.println(currentmonth-month);
				this.clickWebElement(currentmonth-month,prev);
			}
			if(month-currentmonth>0)
			{
				System.out.println(month-currentmonth);
				this.clickWebElement(month-currentmonth,next);
			}
		}
		
		
	}
	
	public void selectCheckInTime(int timeInHours,int timeInMinutes) {
		this.checkInTime.click();
		driver.findElement(By.xpath("//select[@name='checkinTime']//option[@value='"+timeInHours+"']")).click();
		this.checkInTimeMinutes.click();
		driver.findElement(By.xpath("//select[@name='checkinTimeMinutes']//option[@value='"+timeInMinutes+"']")).click();
	}
	
	public void selectCheckOutTime(int timeInHours,int timeInMinutes) {
		this.checkOutTime.click();
		driver.findElement(By.xpath("//select[@name='checkoutTime']//option[@value='"+timeInHours+"']")).click();
		this.checkOutTimeMinutes.click();
		driver.findElement(By.xpath("//select[@name='checkoutTimeMinutes']//option[@value='"+timeInMinutes+"']")).click();
		}
	
	public boolean checkDateFormat(String date) {
		boolean checkFormat;

		if (date.matches("([0-9]{2}/[0-9]{2}/[0-9]{4})")) 
		    checkFormat=true;
		else
		   checkFormat=false;
		
		return checkFormat;
	}
	
	public void currentMonth() {
		String str=driver.findElement(By.xpath("//*[@class='xp__dates-inner xp__dates__checkin']//div[@class='c2-calendar-inner']")).getAttribute("style").split(" ")[1];
		String width=str.substring(1, str.length()-3);
		System.out.println(width);
		System.out.println(driver.findElement(By.xpath("//*[@class='xp__dates-inner xp__dates__checkin']//div[@class='c2-month' and contains(@style,'"+width+"')]//*[contains(@class,'monthname')]")).getText());
	}
	
	public void chooseCheckInDate(String date) throws InvalidDateException {
		if(!this.checkDateFormat(date)) {
			throw new InvalidDateException("Date format Mismatch");
		}
		
		String[] dateFormat=date.split("/");
		
		String day=dateFormat[0];
		String month=dateFormat[1];
		String year=dateFormat[2];
		
		this.checkInDay.clear();
		this.checkInDay.sendKeys(day);
		this.checkInMonth.clear();
		this.checkInMonth.sendKeys(month);
		this.checkInYear.clear();
		this.checkInYear.sendKeys(year);
		
	}
	
	public void chooseCheckOutDate(String date) throws InvalidDateException {
		if(!this.checkDateFormat(date)) {
			throw new InvalidDateException("Date format Mismatch");
		}
		
		String[] dateFormat=date.split("/");
		
		String day=dateFormat[0];
		String month=dateFormat[1];
		String year=dateFormat[2];
		
		this.checkOutDay.clear();
		this.checkOutDay.sendKeys(day);
		this.checkOutMonth.clear();
		this.checkOutMonth.sendKeys(month);
		this.checkOutYear.clear();
		this.checkOutYear.sendKeys(year);
		
	}
	
	public class CarRentalsSearchFiller{
		private String pickUpLocation="";
		private String dropOffLocation="";
		private String pickUpSuggestedLocation="";
		private String dropOffSuggestedLocation="";
		private String checkInDate="";
		private String checkOutDate="";
		private int checkInHour=0;
		private int checkInMinutes=0;
		private int checkOutHour=0;
		private int checkOutMinutes=0;
		public CarRentalsSearchFiller setPickUpLocation(String pickUpLocation) {
			this.pickUpLocation = pickUpLocation;
			return this;
		}
		public CarRentalsSearchFiller setDropOffLocation(String dropOffLocation) {
			this.dropOffLocation = dropOffLocation;
			return this;
		}
		public CarRentalsSearchFiller setPickUpSuggestedLocation(String pickUpSuggestedLocation) {
			this.pickUpSuggestedLocation = pickUpSuggestedLocation;
			return this;
		}
		public CarRentalsSearchFiller setDropOffSuggestedLocation(String dropOffSuggestedLocation) {
			this.dropOffSuggestedLocation = dropOffSuggestedLocation;
			return this;
		}
		public CarRentalsSearchFiller setCheckInDate(String checkInDate) {
			this.checkInDate = checkInDate;
			return this;
		}
		public CarRentalsSearchFiller setCheckOutDate(String checkOutDate) {
			this.checkOutDate = checkOutDate;
			return this;
		}
		public CarRentalsSearchFiller setCheckInHour(int checkInHour) {
			this.checkInHour = checkInHour;
			return this;
		}
		public CarRentalsSearchFiller setCheckInMinutes(int checkInMinutes) {
			this.checkInMinutes = checkInMinutes;
			return this;
		}
		public CarRentalsSearchFiller setCheckOutHour(int checkOutHour) {
			this.checkOutHour = checkOutHour;
			return this;
		}
		public CarRentalsSearchFiller setCheckOutMinutes(int checkOutMinutes) {
			this.checkOutMinutes = checkOutMinutes;
			return this;
		}

	}
	
	public void searchCarForRent(CarRentalsSearchFiller carRentalsFill) throws InvalidDateException {
		getPickUpLocation().sendKeys(carRentalsFill.pickUpLocation);
		getPickUpLocationSuggestedDestinations().get(0).click();
		getReturnLocationDifferent().click();		
		getDropOffLocation().sendKeys(carRentalsFill.dropOffLocation);
		getDropOffLocationSuggestedDestinations().get(0).click();
		getPickUpDateandTimmings().click();
		chooseCheckInDate(carRentalsFill.checkInDate);
		selectCheckInTime(carRentalsFill.checkInHour,carRentalsFill.checkInMinutes);
		getDropOffDateandTimmings().click();
		getDropOffDateandTimmings().click();
		chooseCheckOutDate(carRentalsFill.checkOutDate);
		selectCheckOutTime(carRentalsFill.checkOutHour, carRentalsFill.checkOutMinutes);
	}
}

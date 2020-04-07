package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumWebdriver.InvalidDateException;

public class FlightsPage extends BasePage{
	
	public FlightsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//label[contains(@title,'Round-trip')]")
	protected WebElement roundTrip;
	
	public WebElement getRoundTrip() {
		return roundTrip;
	}

	public WebElement getOneWay() {
		return oneWay;
	}

	public WebElement getMultiCity() {
		return multiCity;
	}

	public WebElement getFlightOrigin() {
		return flightOrigin;
	}

	public WebElement getFlightDestination() {
		return flightDestination;
	}

	public WebElement getNextMonthNavig() {
		return nextMonthNavig;
	}

	public WebElement getPreviousMonthNavig() {
		return previousMonthNavig;
	}

	public WebElement getCurrentmonth() {
		return currentmonth;
	}


	public WebElement getDay() {
		return day;
	}

	public WebElement getSearch() {
		return search;
	}


	@FindBy(xpath="//label[contains(@title,'One-way')]")
	protected WebElement oneWay;
	
	@FindBy(xpath="//label[contains(@title,'Multi-city')]")
	protected WebElement multiCity;
	
	@FindBy(xpath="//input[@type='text' and @aria-label='Flight origin input']")
	protected WebElement flightOrigin;
	
	@FindBy(xpath="//input[@type='text' and @aria-label='Flight destination input']")
	protected WebElement flightDestination;
	
	@FindBy(xpath="//*[@role='button' and @aria-label='Next month']")
	protected WebElement nextMonthNavig;
	
	@FindBy(xpath="//*[@role='button' and @aria-label='Previous month']")
	protected WebElement previousMonthNavig;
	
	@FindBy(xpath="//*[contains(@class,'month') and @aria-hidden='false'][1]")
	protected WebElement currentmonth;
	

	
	@FindBy(xpath="//*[contains(@class,'month') and @aria-hidden='false' and contains(@id,'202004')]//div[@class='day' and text()='1']")
	protected WebElement day;
	
	@FindBy(xpath="//button[@title='Search flights']")
	protected WebElement search;
	
	@FindBy(xpath="//div[contains(@id,'depart')]")
	protected WebElement selectDepart;
	
	@FindBy(xpath="//div[contains(@id,'return')]")
	protected WebElement selectReturn;
	
	@FindBy(xpath="//div[@class='multi']//input[@placeholder='From where?']")
	protected List<WebElement> multicityFlightOrigin;
	
	@FindBy(xpath="//div[@class='multi']//input[@placeholder='To where?']")
	protected List<WebElement> multicityFlightdestination;
	
	@FindBy(xpath="//div[@class='multi']//div[contains(@id,'departDate')  and contains(@class,'dateInput')]")
	protected List<WebElement> multicityDepart;
	
	@FindBy(xpath="//div[@class='multi']//div[contains(@class,'depart-time')]")
	protected List<WebElement> multicityDepartTime;
	
	@FindBy(xpath="//div[@class='multi']//div[contains(@class,'remove-leg')]")
	protected WebElement multicityRemoveLastSearch;
	
	@FindBy(xpath="//div[@class='multi']//button[@title='Remove flight']")
	protected List<WebElement> multicityRemoveflightSearch;
	
	public List<WebElement> getMulticityRemoveflightSearch() {
		return multicityRemoveflightSearch;
	}


	@FindBy(xpath="//div[@class='multi']//a[@class='addMoreLegs']")
	protected WebElement multicityAddFlightSearch;
		
	public List<WebElement> getMulticityFlightOrigin() {
		return multicityFlightOrigin;
	}

	public List<WebElement> getMulticityFlightdestination() {
		return multicityFlightdestination;
	}

	public List<WebElement> getMulticityDepart() {
		return multicityDepart;
	}

	public List<WebElement> getMulticityDepartTime() {
		return multicityDepartTime;
	}

	public WebElement getMulticityRemoveLastSearch() {
		return multicityRemoveLastSearch;
	}


	public WebElement getMulticityAddFlightSearch() {
		return multicityAddFlightSearch;
	}

	public WebElement getMulticityCurrentMonth() {
		return multicityCurrentMonth;
	}

	public WebElement getMulticityClearTotalSearch() {
		return multicityClearTotalSearch;
	}

	public WebElement getMuticityNavigateToPreviousMonth() {
		return muticityNavigateToPreviousMonth;
	}

	public WebElement getMuticityNavigateToNextMonth() {
		return muticityNavigateToNextMonth;
	}


	@FindBy(xpath="//*[contains(@class,'Datepicker-Calendar')]//*[@class='col col-month col-month-m '][1]")
	protected WebElement multicityCurrentMonth;

	@FindBy(xpath="//div[@class='multi']//div[contains(@class,'clear-all')]")
	protected WebElement multicityClearTotalSearch;
	
	@FindBy(xpath="//*[contains(@class,'Datepicker-Calendar')]//*[@role='button' and @class='navItem prevMonth']")
	protected WebElement muticityNavigateToPreviousMonth;

	@FindBy(xpath="//*[contains(@class,'Datepicker-Calendar')]//*[@role='button' and @class='navItem nextMonth']")
	protected WebElement muticityNavigateToNextMonth;
	
	@FindBy(xpath=" //div[@class='multi']//button[@title='Search flights']")
	protected WebElement multicitySearch;

	public WebElement getMulticitySearch() {
		return multicitySearch;
	}

	public WebElement getSelectDepart() {
		return selectDepart;
	}

	public WebElement getSelectReturn() {
		return selectReturn;
	}
	


	
	public void selectFromCalendar(String date,WebElement currentMonth,WebElement prev,WebElement next) throws InvalidDateException {
		
		if(!this.checkDateFormat(date)) {
			throw new InvalidDateException("Date Format Mismatch"); 
		}
		
		String[] dateformat=date.split("/");
		int day=Integer.parseInt(dateformat[0]);
		int month=Integer.parseInt(dateformat[1]);
		int year=Integer.parseInt(dateformat[2]);
		String[] currentdate;
		try {
			currentdate=currentMonth.getAttribute("id").split("-");
		}catch(StaleElementReferenceException e) {
			currentdate=currentMonth.getAttribute("id").split("-");
		}
		System.out.println(currentdate[1]+" "+currentdate[0]);
		int currentmonth=Integer.parseInt(currentdate[1].substring(currentdate[1].length()-2));
		System.out.println(currentdate[1].substring(currentdate[1].length()-2));
		int currentyear=Integer.parseInt(currentdate[1].substring(0,currentdate[1].length()-2));
		System.out.println(currentdate[1].substring(0,currentdate[1].length()-2));
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
		try {
		driver.findElement(By.xpath("//*[contains(@class,'month') and @aria-hidden='false' and contains(@id,'"+dateformat[2]+dateformat[1]+"')]//div[@class='day' and text()='"+day+"']")).click();
		}catch(Exception e) {
			driver.findElement(By.xpath("//*[contains(@class,'Datepicker-Calendar')]//*[contains(@id,'"+dateformat[2]+dateformat[1]+"')]//div[@class='day' and text()='"+day+"']")).click();
		}
	}
	
	public void selectAirportWithName(String airport) {
		driver.findElement(By.xpath("//ul[@role='listbox']//*[contains(text(),'"+airport+"')]//parent::li[contains(@id,'ap')]")).click();
	}
	
	public void selectMulticityOriginAirportWithName(String airport,int i) {
		driver.findElement(By.xpath("//div[contains(@id,'origin"+i+"-smartbox-dropdown')]//ul[@role='listbox']//*[contains(text(),'"+airport+"')]//ancestor::li[contains(@id,'ap')]")).click();
	}
	
	public void selectMulticityDestinationAirportWithName(String airport,int i) {
		driver.findElement(By.xpath("//div[contains(@id,'destination"+i+"-smartbox-dropdown')]//ul[@role='listbox']//*[contains(text(),'"+airport+"')]//ancestor::li[contains(@id,'ap')]")).click();
	}
	
	
	public boolean checkDateFormat(String date) {
		boolean checkFormat;

		if (date.matches("([0-9]{2}/[0-9]{2}/[0-9]{4})")) 
		    checkFormat=true;
		else
		   checkFormat=false;
		
		return checkFormat;
	}
	
	public class FlightSearchFiller{
		private String origin="";
		private String originAirportName="";
		private String destination="";
		private String destinationAirportName="";
		private String departDate="";
		private String returnDate="";
		
		public WebElement ECONOMY;
		public WebElement BUSINESS;
		public WebElement PREMIUMECONOMY;
		public WebElement FIRST;
		public WebElement MULTIPLE;
		
		
		private int adults=1;
		private int students=0;
		private int seniors=0;
		private int youth=0;
		private int child=0;
		private int seat=0;
		private int seatInfant=0;
		private int lapInfant=0;
		
	
		public FlightSearchFiller setOrigin(String origin) {
			this.origin = origin;
			return this;
		}
		public FlightSearchFiller setOriginAirportName(String originAirportName) {
			this.originAirportName = originAirportName;
			return this;
		}
		public FlightSearchFiller setDestination(String destination) {
			this.destination = destination;
			return this;
		}
		public FlightSearchFiller setDestinationAirportName(String destinationAirportName) {
			this.destinationAirportName = destinationAirportName;
			return this;
		}
		public FlightSearchFiller setDepartDate(String departDate) {
			this.departDate = departDate;
			return this;
		}
		public FlightSearchFiller setReturnDate(String returnDate) {
			this.returnDate = returnDate;
			return this;
		}
		public FlightSearchFiller setAdults(int adults) {
			this.adults = adults;
			return this;
		}
		public FlightSearchFiller setStudents(int students) {
			this.students = students;
			return this;
		}
		public FlightSearchFiller setSeniors(int seniors) {
			this.seniors = seniors;
			return this;
		}
		public FlightSearchFiller setYouth(int youth) {
			this.youth = youth;
			return this;
		}
		public FlightSearchFiller setChild(int child) {
			this.child = child;
			return this;
		}
		public FlightSearchFiller setSeat(int seat) {
			this.seat = seat;
			return this;
		}
		public FlightSearchFiller setSeatInfant(int seatInfant) {
			this.seatInfant = seatInfant;
			return this;
		}
		public FlightSearchFiller setLapInfant(int lapInfant) {
			this.lapInfant = lapInfant;
			return this;
		}
		
	}
	
	public void searchFlightsForRoundTrip(FlightSearchFiller searchFill) throws InterruptedException {	
		slowSend(getFlightOrigin(),searchFill.origin);
		selectAirportWithName(searchFill.originAirportName);
		getFlightDestination().clear();
		slowSend(getFlightDestination(),searchFill.destination);
		selectAirportWithName(searchFill.destinationAirportName);
		try {
		getSelectDepart().click();
		selectFromCalendar(searchFill.departDate, getCurrentmonth(), getPreviousMonthNavig(), getNextMonthNavig());
		getSelectReturn().click();
		selectFromCalendar(searchFill.returnDate, getCurrentmonth(), getPreviousMonthNavig(), getNextMonthNavig());
		getSearch().click();
		}
		catch(InvalidDateException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void searchFlightsForOneWay(FlightSearchFiller searchFill) throws InterruptedException {	
		slowSend(getFlightOrigin(),searchFill.origin);
		selectAirportWithName(searchFill.originAirportName);
		getFlightDestination().clear();
		slowSend(getFlightDestination(),searchFill.destination);
		selectAirportWithName(searchFill.destinationAirportName);
		getSelectDepart().click();
		try {
			selectFromCalendar(searchFill.departDate, getCurrentmonth(), getPreviousMonthNavig(), getNextMonthNavig());
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	public void searchFlightsForMultiCity(FlightSearchFiller searchFill,int index) throws InterruptedException {
		slowSend(getMulticityFlightOrigin().get(index),searchFill.origin);
		selectMulticityOriginAirportWithName(searchFill.originAirportName,index);
		slowSend(getMulticityFlightdestination().get(index),searchFill.destination);
		selectMulticityDestinationAirportWithName(searchFill.destinationAirportName,index);
		getMulticityDepart().get(index).click();
		try {
			selectFromCalendar(searchFill.departDate, getMulticityCurrentMonth(), getMuticityNavigateToPreviousMonth(), getMuticityNavigateToNextMonth());
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

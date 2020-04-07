package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumWebdriver.InvalidDateException;

public class StaysPage extends BasePage
{
	
	
	@FindBy(xpath="//input[@id='ss']")
	protected WebElement searchField;
	
	@FindBy(xpath="//*[@id='destination__error']/div/text()[2]")
	protected WebElement errorMessage;
	
	@FindBy(xpath="//button[@class='sb-searchbox__button ']")
	protected WebElement searchButton;
	
	@FindBy(xpath="//*[@id='xp__guests__toggle']")
	protected WebElement roomsandOccupancyButton;
	
	@FindBy(xpath="//div[@data-component='search/destination/input']/div[@role='alert']")
	protected WebElement searchAlert;
	
	@FindBy(xpath="//ul[@aria-label=\"List of suggested destinations \"]")
	protected WebElement suggestedDestinationsBox;
	
	@FindBy(xpath="//*[@class='xp__dates xp__group']")
	protected WebElement dateField;

	@FindBy(xpath="//*[@data-mode='checkin' and @data-calendar2-title='Check-in']")
	protected WebElement checkInField;
	
	@FindBy(xpath="//*[@data-mode='checkout' and @data-calendar2-title='Check-out']")
	protected WebElement checkOutField;
	
	
	@FindBy(xpath="//*[@class='xp__dates xp__group']//*[@class='bui-calendar']")
	protected WebElement calenderPanel;
	
	@FindBy(xpath="//div[@class='xp__dates xp__group']//td[@class='bui-calendar__date bui-calendar__date--today']")
	protected WebElement highlighted_date;
	
	@FindBy(xpath="//div[@class='xp__dates xp__group']//div[@data-bui-ref='calendar-month']")
	protected List<WebElement> defaultMonthsInCalenderPanel;
	
	@FindBy(xpath="//div[@data-bui-ref='calendar-next']")
	protected WebElement calenderNext;
	
	@FindBy(xpath="//div[@data-bui-ref='calendar-prev']")
	protected WebElement calenderPrevious;
	

	@FindBy(xpath="//div[@class='xp__input-group xp__guests']")
	protected WebElement roomsAndOccupancies;
	
	@FindBy(xpath="//div[@class='xp__input-group xp__guests']//*[@class='xp__guests__inputs focussable ']")
	protected WebElement noOfPersonsFieldDropDown;
	
	@FindBy(xpath="//div[@class='sb-group__field sb-group__field-adults']//input[@name='group_adults']")
	protected WebElement adults;
	
	@FindBy(xpath="//div[@class='sb-group__field sb-group-children ']//input[@name='group_children']")
	protected WebElement childrens;
	
	@FindBy(xpath="//div[@class='sb-group__field sb-group__field-rooms']//input[@name='no_rooms']")
	protected WebElement rooms;
	
	
	@FindBy(xpath="//div[@class='sb-group__field sb-group__field-adults']//button[@aria-label='Decrease number of Adults']")
	protected WebElement minusAdultsButton;
	
	@FindBy(xpath="//div[@aria-label='Rooms and occupancy']//button[@aria-label='Increase number of Adults']")
	protected WebElement plusAdultsButton;
	

	@FindBy(xpath="//div[@class='sb-group__field sb-group__field-adults']//button[@aria-label='Decrease number of Children']")
	protected WebElement minusChildrenButton;
	
	@FindBy(xpath="//div[@aria-label='Rooms and occupancy']//button[@aria-label='Increase number of Children']")
	protected WebElement plusChildrenButton;
	
	
	@FindBy(xpath="//div[@class='sb-group__field sb-group__field-adults']//button[@aria-label='Decrease number of Rooms']")
	protected WebElement minusRoomsButton;
	
	@FindBy(xpath="//div[@aria-label='Rooms and occupancy']//button[@aria-label='Increase number of Rooms']")
	protected WebElement plusRoomsButton;
	
	@FindBy(xpath="//ul[@aria-label='List of suggested destinations ']//li")
	protected List<WebElement> searchList;
	

	
	

	protected WebElement checkIndate;
	protected WebElement checkOutdate;
	protected WebElement searchItem;


	public StaysPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		driver.get("http://www.booking.com");
		checkIndate=null;
		checkOutdate=null;
	}
	
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}


	public WebElement getCheckInField() {
		return checkInField;
	}


	public WebElement getCheckOutField() {
		return checkOutField;
	}


	public WebElement getHighlighted_date() {
		return highlighted_date;
	}


	public List<WebElement> getDefaultMonthsInCalenderPanel() {
		return defaultMonthsInCalenderPanel;
	}


	public List<WebElement> getSearchList() {
		return searchList;
	}


	public WebElement getCheckIndate() {
		return checkIndate;
	}


	public WebElement getCheckOutdate() {
		return checkOutdate;
	}


	public WebElement getSearchItem() {
		return searchItem;
	}
	
	public void sendDataToSearchBox(String data) {
		getSearchField().sendKeys(data);
	}
	

	public void search() {
			this.getSearchButton().click();
	}
	
	public boolean roomsandOccupancyButtonisPresent() {
		return roomsandOccupancyButton.isDisplayed();
	}
	
	
	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getErrorMessageAtSearchBox() {
		return errorMessage;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getRoomsandOccupancyButton() {
		return roomsandOccupancyButton;
	}

	public WebElement getSearchAlert() {
		return searchAlert;
	}
	
	public WebElement getSuggestedDestinationsBox() {
		return suggestedDestinationsBox;
	}
	
	public WebElement getDateField() {
		return dateField;
	}
	
	public WebElement getCalenderPanel() {
		return calenderPanel;
	}

	public WebElement getHighlightedDate() {
		return highlighted_date;
	}
	
	public List<WebElement> getdefaultMonthsInCalenderPanel() {
		return defaultMonthsInCalenderPanel;
	}
	
	
	
	
	
	public WebElement getRoomsAndOccupancies() {
		return roomsAndOccupancies;
	}
	
	public WebElement getNoOfPersonsFieldDropDown() {
		return noOfPersonsFieldDropDown;
	}
	
	
	public WebElement getAdults() {
		return adults;
	}
	
	
	public WebElement getChildrens() {
		return childrens;
	}
	
	public WebElement getRooms() {
		return rooms;
	}
	
	public WebElement getCalenderPrevious() {
		return calenderPrevious;
	}
	
	
	public WebElement getMinusAdultsButton() {
		return minusAdultsButton;
	}


	public WebElement getPlusAdultsButton() {
		return plusAdultsButton;
	}


	public WebElement getMinusChildrenButton() {
		return minusChildrenButton;
	}


	public WebElement getPlusChildrenButton() {
		return plusChildrenButton;
	}


	public WebElement getMinusRoomsButton() {
		return minusRoomsButton;
	}


	public WebElement getPlusRoomsButton() {
		return plusRoomsButton;
	}
	
	

	
	public class StaysPageSearchFiller{
		private String destination="";
		private String checkIn="";
		private String checkOut="";
		private int adults=1;
		private int children=0;
		private int rooms=0;
		public StaysPageSearchFiller setDestination(String destination) {
			this.destination = destination;
			return this;
		}
		public StaysPageSearchFiller setCheckIn(String checkIn) {
			this.checkIn = checkIn;
			return this;
		}
		public StaysPageSearchFiller setCheckOut(String checkOut) {
			this.checkOut = checkOut;
			return this;
		}
		public StaysPageSearchFiller setAdults(int adults) {
			this.adults = adults;
			return this;
		}
		public StaysPageSearchFiller setChildren(int children) {
			this.children = children;
			return this;
		}
		public StaysPageSearchFiller setRooms(int rooms) {
			this.rooms = rooms;
			return this;
		}
		
	}
	
	
	public void selectSearchItem(int index) {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-label='List of suggested destinations ']")));
		if(index>searchList.size() && index<=-1)
		{
			throw new NoSuchElementException("Selected Item Not in List");
		}
		searchItem=driver.findElement(By.xpath("//ul[@aria-label='List of suggested destinations ']//li[@data-i='"+index+"']"));
		searchItem.click();
		
	}
	
	
	
	
	
public void moveToPaticularDateInCalender(String date) throws InvalidDateException {
		
		if(!checkDateFormat(date)) {
			throw new InvalidDateException("Date format Mismatch");
		}
	
		String[] currentDate;
		int currentMonth;
		if(checkIndate==null) {
			currentDate=getHighlightedDate().getAttribute("data-date").split("-");
			currentMonth=Integer.parseInt(currentDate[1])+1;
		}
		else {
			currentDate=checkIndate.getAttribute("data-date").split("-");	
			currentMonth=Integer.parseInt(currentDate[1]);
		}
		
		String[] selectedDate=date.split("-");
		int currentYear=Integer.parseInt(currentDate[0]);
		int selectedYear=Integer.parseInt(selectedDate[0]);
		int selectedMonth=Integer.parseInt(selectedDate[1]);
		int currentDay=Integer.parseInt(currentDate[2]);
		int selectedDay=Integer.parseInt(selectedDate[2]);
		
		if(selectedYear<currentYear) {
			throw new InvalidDateException("Year is before current Year");
		}
		if(selectedYear==currentYear && selectedMonth<currentMonth) {
			throw new InvalidDateException("Month is before current month");
			
		}
		if(selectedYear==currentYear && selectedMonth==currentMonth && selectedDay<currentDay) {
			throw new InvalidDateException("Day is before current Day");
		}
		
		int noOfClicks=0;
		
		if(selectedYear==currentYear) {
			noOfClicks=selectedMonth-currentMonth;
		}else{
			noOfClicks=selectedMonth+12-currentMonth-1;
		}
		
		System.out.println(noOfClicks);
		
		clickWebElement(noOfClicks,getCalenderNext());
		
		
	}
	
	
	
	
	public boolean checkDateFormat(String date) {
		boolean checkFormat;

		if (date.matches("([0-9]{4}-[0-9]{2}-[0-9]{2})")) 
		    checkFormat=true;
		else
		   checkFormat=false;
		
		return checkFormat;
	}
	
	public WebElement getCalenderNext() {
		return calenderNext;
	}

	public boolean selectCheckInDate(String date){
		
		this.displayCheckInCalendar();
		
		while(getCalenderPrevious().isDisplayed()) {
			getCalenderPrevious().click();
		}
		try {
			moveToPaticularDateInCalender(date);
			try {
			
			checkIndate=driver.findElement(By.xpath("//div[@class='xp__dates xp__group']//td[@data-date='"+date+"']"));
			checkIndate.click();
		
			}
			catch(StaleElementReferenceException ex)
			{
				
			}
			return true;
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public void clickCheckInCheckOut() {
		if(!this.calenderPanel.isDisplayed())	this.dateField.click();
	}
	
	public boolean selectCheckOutDate(String date) {
		
		this.displayCheckOutCalendar();
		
		try {
			moveToPaticularDateInCalender(date);
			checkOutdate=driver.findElement(By.xpath("//div[@class='xp__dates xp__group']//td[@data-date='"+date+"']"));
			checkOutdate.click();
			return true;
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	public void displayCheckOutCalendar() {
		if(!this.calenderPanel.isDisplayed())	this.checkOutField.click();
		
	}


	public void displayCheckInCalendar() {
		if(!this.calenderPanel.isDisplayed())	this.checkInField.click();
		
	}
	
	public void selectNumberOfRoomsAndOccupancies(int adults,int children,int occupancies) {
		this.clickWebElement(adults, this.getPlusAdultsButton());
		this.clickWebElement(children, this.getPlusChildrenButton());
		this.clickWebElement(occupancies, this.getPlusRoomsButton());
	}
	
	public void searchStays(StaysPageSearchFiller stayspageFill) {
		getSearchField().sendKeys(stayspageFill.destination);
		//selectSearchItem(0);
		selectCheckInDate(stayspageFill.checkIn);
		selectCheckOutDate(stayspageFill.checkOut);
		getRoomsAndOccupancies().click();
		selectNumberOfRoomsAndOccupancies(stayspageFill.adults, stayspageFill.children, stayspageFill.rooms);
		
	}
	
}

package UserStorytestCases;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.CarRentalsPage;
import Pages.FlightsPage;
import Pages.FlightsPage.FlightSearchFiller;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.StaysPage;
import extentReport.ExtentReportListeners;
import seleniumWebdriver.DriverNotFoundException;
import seleniumWebdriver.InvalidDateException;
import seleniumWebdriver.WebDriverFactory;

@Listeners(ExtentReportListeners.class)
public class SearchingForDifferentBookingOptions {
	
	WebDriver browser;
	
    StaysPage stayspage;
    CarRentalsPage carRentalspage;
    FlightsPage flightspage;
    
	
    @Given("Open booking.com through chrome browser")
	@BeforeClass
	public void setUp() {
		
		
		try {
			browser=WebDriverFactory.getDriver("chrome");
			stayspage=new StaysPage(browser);
			carRentalspage=new CarRentalsPage(browser);
			flightspage=new FlightsPage(browser);
			browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (DriverNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
    
    @Given("Navigate to stays page")
    @BeforeClass
	public void navigate_to_stays_page() {
	}
	
	
	
    @When("Search with valid location, check in date, check out date, rooms and occupancies")
	@Test
	public void staysSearch() {
		StaysPage.StaysPageSearchFiller staysdata=stayspage.new StaysPageSearchFiller();
		staysdata.setDestination("Hyderabad")
		.setCheckIn("2020-07-12")
		.setCheckOut("2020-08-04")
		.setAdults(3)
		.setChildren(5)
		.setRooms(2);
		stayspage.searchStays(staysdata);
		stayspage.getSearchButton().click();	
	}
    
    
	@Then("check page navigates to suggested stays page")
	public void page_navigates_to_suggested_stays_page() {
	}
	
	
	@Test
	public void carRentalSearchForReturnLocationSame() throws InvalidDateException, InterruptedException {
		stayspage.getCarRentals().click();
		carRentalspage.getReturnLocationSame().click();
		CarRentalsPage.CarRentalsSearchFiller carsearchdata=carRentalspage.new CarRentalsSearchFiller();
		carsearchdata.setPickUpLocation("Hyderabad")
		.setDropOffLocation("pune")
		.setCheckInDate("12/07/2020")
		.setCheckOutDate("12/08/2020")
		.setCheckInHour(10)
		.setCheckInMinutes(30)
		.setCheckOutHour(10)
		.setCheckOutMinutes(15);
		carRentalspage.searchCarForRent(carsearchdata);
		carRentalspage.getCarRentalsSearch().click();
		
	}
	
	@Given("Navigate to fights page")
	public void navigate_to_fights_page() {
		stayspage.getFlights().click();  
	}
	
	
	@When("Search flights for round trip with all valid details")
	public void search_flights_for_round_trip_with_all_valid_details() throws InterruptedException {
		FlightSearchFiller roundTripSearchFill=flightspage.new FlightSearchFiller();
		roundTripSearchFill.setOrigin("Hyderabad")
		.setDestination("Pune")
		.setOriginAirportName("Rajiv")
		.setDestinationAirportName("Pune")
		.setDepartDate("12/07/2020");
		flightspage.getRoundTrip().click();
		flightspage.getFlightOrigin().clear();
		flightspage.searchFlightsForRoundTrip(roundTripSearchFill);
		flightspage.getSearch().click();
	}
	
	
	@Then("check page navigates to suggested round trip flights")
	public void check_page_navigates_to_suggested_round_trip_flights() {
	    
	}
	
	
	
	@Given("click on one way")
	public void click_on_one_way() {
		flightspage.getOneWay().click();
		
	}

	@When("Search flights for one way with all valid details")
	public void search_flights_for_one_way_with_all_valid_details() throws InterruptedException {
		flightspage.getFlightOrigin().clear();	
		FlightSearchFiller onewaySearchFill=flightspage.new FlightSearchFiller();
		onewaySearchFill.setOrigin("Hyderabad")
		.setDestination("Pune")
		.setOriginAirportName("Rajiv")
		.setDestinationAirportName("Pune")
		.setDepartDate("12/07/2020");
		flightspage.searchFlightsForOneWay(onewaySearchFill);
		flightspage.getSearch().click();
	}

	@Then("check page navigates to suggested one way flights")
	public void check_page_navigates_to_suggested_one_way_flights() {
	}
	

	
	@Given("click on multicity")
	public void click_on_multicity() {
		flightspage.getMultiCity().click();
	}

	@When("Search mutiple flights with all valid details")
	public void search_mutiple_flights_with_all_valid_details() throws InterruptedException {
		flightspage.getMulticityClearTotalSearch();
		FlightSearchFiller multicitySearchFill=flightspage.new FlightSearchFiller();
		multicitySearchFill.setOrigin("Hyderabad")
		.setDestination("Pune")
		.setOriginAirportName("Rajiv")
		.setDestinationAirportName("Pune")
		.setDepartDate("12/07/2020");
		flightspage.searchFlightsForMultiCity(multicitySearchFill, 0);
		flightspage.getMulticitySearch().click();
	}

	@Then("check page navigates to suggested multiple flights")
	public void check_page_navigates_to_suggested_multiple_flights() {
	    
	}
	
	@AfterClass
	@After
	public void CloseDriver() {
		stayspage.closeDriver();
	}
	
	
	 


}

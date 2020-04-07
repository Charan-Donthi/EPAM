Feature: Stay page Searching in booking.com

	Scenario: search for stays with all valid details
	Given Open booking.com through chrome browser
	And Navigate to stays page 
	When Search with valid location, check in date, check out date, rooms and occupancies
	Then check page navigates to suggested stays page
	
	Scenario: flight page round trip search functionality with all valid details
	Given Open booking.com through chrome browser
	And Navigate to fights page 
	When Search flights for round trip with all valid details
	Then check page navigates to suggested round trip flights 
	
	Scenario: flight page one way search functionality with all valid details
	Given Open booking.com through chrome browser
	And Navigate to fights page
	And click on one way
	When Search flights for one way with all valid details
	Then check page navigates to suggested one way flights
	
	Scenario: flight page multicity search functionality with all valid details
	Given Open booking.com through chrome browser
	And Navigate to fights page
	And click on multicity
	When Search mutiple flights with all valid details
	Then check page navigates to suggested multiple flights  
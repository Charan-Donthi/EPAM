#Author: your.Charan_Donthi@epam.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Stay page Searching in booking.com

	@staysSearch
	Scenario: search for stays with all valid details
	Given Open booking.com through chrome browser
	And Navigate to stays page 
	When Search with valid location, check in date, check out date, rooms and occupancies
	Then check page navigates to suggested stays page
	
	@roundTripFlightSearch
	Scenario: flight page round trip search functionality with all valid details
	Given Open booking.com through chrome browser
	And Navigate to fights page 
	When Search flights for round trip with all valid details
	Then check page navigates to suggested round trip flights 
	
	@oneWayFlightSearch
	Scenario: flight page one way search functionality with all valid details
	Given Open booking.com through chrome browser
	And Navigate to fights page
	And click on one way
	When Search flights for one way with all valid details
	Then check page navigates to suggested one way flights
	
	@multiCityFlightSearch
	Scenario: flight page multicity search functionality with all valid details
	Given Open booking.com through chrome browser
	And Navigate to fights page
	And click on multicity
	When Search mutiple flights with all valid details
	Then check page navigates to suggested multiple flights

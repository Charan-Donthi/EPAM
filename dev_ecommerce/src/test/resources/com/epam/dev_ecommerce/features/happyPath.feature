Feature: User successfully checks out selecting a product

	Scenario: Selecting desired category form listed categories
	Given User Launching WebApplication through Chrome
	And landing in home page
	When user navigates to Main Menu 
	Then check user could able to select desired category
	And check user lands in sub category page
	And check availability of sub categories 

	Scenario: Selecting desired sub category from listed sub categories
	Given User in sub category page
	When user selects desired sub category 
	Then check user lands in products page
	And check availability of products
	 
	Scenario: Selecting desired product from listed products
	Given User in products page
	When user selects desired product 
	Then check user lands in product details page
	And check user can able to select desired quantity
	
	Scenario: Adding product to cart
	Given User in product details page
	And desired quantity is selected
	When User adds product to cart by clicking add to cart
	Then check user lands in cart message page
	And check user can view cart 
	And check availability of selected product in cart
	
	
	Scenario: Updating quantity of particular product in cart
	Given User in cart page
	When User updates the quantity by clicking increment or decrement
	Then check product quantity is equal to updated quantity
	
	Scenario: Checking out 
	Given User has products in cart
	When User checks out
	Then check user lands in status page
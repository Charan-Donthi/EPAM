#Author: Charan_Donthi@epam.com
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
Feature: Successfull checking out

  @checkOuts
  Scenario Outline: checking out with only one product
    Given User launches <browser_name> browser
    And User opens WebApplication
    When User navigates to Main menu
    And User selects <category_name> category
    And User navigates to subategory page
    And User selects <subcategory_name> subcategory
    And User navigates to products page
    And User selects <product_name> product
    And User navigates to productdetails page
    And User selects <required_quantity> quantity
    And User adds product to cart
    And User navigates to cart
    And User checks out
    Then Check whether status of checkout page is <status>

    Examples: 
      | browser_name | category_name | subcategory_name  | product_name | required_quantity | status    |
      | "chrome"     | "Electronics" | "TV"              | "vbncg"      |                 1 | "success" |
      | "chrome"     | "Fashion"     | "Washing Machine" | "Shirt"      |                 1 | "success" |

  @checkOutWithMoreThanOne
  Scenario Outline: checking out with more than one product
    Given User launches <browser_name> browser
    And User opens WebApplication
    When User navigates to Main menu
    And User selects <product_name1> product under <subcategory_name1> subcategory under <category_name1> category
    And User selects <required_quantity1> quantity
    And User adds product to cart
    And User selects <product_name2> product under <subcategory_name2> subcategory under <category_name2> category
    And User selects <required_quantity2> quantity
    And User adds product to cart
    And User navigates to cart
    And User checks out
    Then Check whether status of checkout page is <status>

    Examples: 
      | browser_name | category_name1 | subcategory_name1 | product_name1 | required_quantity1 | category_name2      | subcategory_name2 | product_name2 | required_quantity2 | status    |
      | "chrome"     | "Fashion"      | "Men's Wear"      | "Tops"        |                  1 | "Fashion"           | "Washing Machine" | "Shirt"       |                 1 | "success" |
      | "chrome"     | "Electronics"  | "TV"              | "vbncg"       |                  1 | "Books and Audible" | "Women's Wear"    | "Sofa"        |                 1 | "success" |

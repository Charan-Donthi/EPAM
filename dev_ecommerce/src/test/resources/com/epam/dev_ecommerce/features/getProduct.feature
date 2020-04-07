#Author: your.email@your.domain.com
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
Feature: Get Response validation for product details

  Scenario Outline: Response Validation of product details by productId
    Given Rest Base URL
    When perform GET method on  Base Path /product/<productId>
    Then check response <status_code>
    And check response contains product details with no null values

    Examples: 
      | productId | status_code |
      |        -1 |         404 |
      |       500 |         404 |
      |      1000 |         404 |
      |         1 |         200 |
      |         2 |         200 |
      |       -99 |         404 |
      |       -10 |         404 |
      |         3 |         200 |
      |         4 |         200 |
      |       -66 |         404 |

  Scenario Outline: Response Validation of product details of particular subcategory
    Given Rest Base URL
    When perform GET method on Base Path /subcategory/<subCategoryId>/products
    Then check response <status_code>
    And check response contains <Array_of_products>
    And each product contains product details with no null values

    Examples: 
      | subCategoryId | status_code | Array_of_products |
      |             1 |         200 | "true"            |
      |             2 |         200 | "true"            |
      |            -1 |         404 | "false"           |
      |           500 |         404 | "false"           |
      |             3 |         200 | "true"            |
      |             4 |         200 | "true"            |
      |          1000 |         404 | "false"           |
      |           -99 |         404 | "false"           |
      |           -10 |         404 | "false"           |
      |           -66 |         404 | "false"           |

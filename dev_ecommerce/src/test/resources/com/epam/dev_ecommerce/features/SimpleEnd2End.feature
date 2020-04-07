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
@End2End
Feature: check categories are same in UI, DB and Rest


  @GetFromRest
  Scenario: Getting categories form Rest
    Given RestApi Base URL 
    When Perform GET method on Base path "/categories"
    Then check status code is 200
    And check Response has list of categories
    And check Rest categories are same as categories in UI
    And check Rest categories are same as categories in DB

   

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
@eCom
Feature: Place an order for any product

  @product1
  Scenario: eCommerce login
    Given user navigates to the ecom HomePage
    When user adds any product in the cart
    And user navigates to the cartpage
    And user clicks on checkout
    And user enters the requested details and clicks on contiue
    And user validates the order details
    And user clicks on finish
    Then order should be placed and order confirmation page should be displayed 	
    
  @product2  
  Scenario: eCommerce login2
    Given user navigates to the ecom HomePage
    When user adds product2 in the cart
    And user navigates to the cartpage
    And user clicks on checkout
    And user enters the requested details and clicks on contiue
    And user validates the order details
    And user clicks on finish
    Then order should be placed and order confirmation page should be displayed 	

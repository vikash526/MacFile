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

Feature: Login functionality
  #I want to use this template for my feature file


  Scenario: Login with valid credentials
    Given User navigate to login page
    When User enter valid email address "amotooricap9@gmail.com"
    And User enter valid password "12345"
    And User click on Login button
    Then User should be logged in successfully


  Scenario: Login with invalid credentials
    Given User navigate to login page
    When User enter invalid email address "amotooricap9@gmail.in"
    And User enter invalid password "121"
    And User click on Login button
    Then User should get error message
    

  Scenario: Login with invalid email and valid password
    Given User navigate to login page
    When User enter invalid email address "amotooricap9@gmail.in"
    And User enter valid password "12345"
    And User click on Login button
    Then User should get error message
    
 
  Scenario: Login with valid email and invalid password
    Given User navigate to login page
    When User enter valid email address "amotooricap9@gmail.com"
    And User enter invalid password "121"
    And User click on Login button
    Then User should get error message
    

  Scenario: Login without credentials
    Given User navigate to login page
    When User dont enter any email address
    And User dont enter any password
    And User click on Login button
    Then User should get error message
    
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |

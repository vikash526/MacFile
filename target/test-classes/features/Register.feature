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
# (Comments)
#Sample Feature Definition Template
#
Feature: Register functionality
  #I want to use this template for my feature file
#
#
  #Scenario: User create an account with only mandatory fields
    #Given User navigates to Register account page
    #When User enter details in below fields
    #
    #|firstName	|Vikash					|
    #|lastName		|Kumar					|
    #|email			|vik@gmail.com	|
    #|telephone	|9988774455			|
    #|password		|manpur					|
    #
    #And User selects privacy policy
    #And User click on continue button
    #Then User account should be created successfully
    #
#
  #Scenario: User create an account with all fields
    #Given User navigates to Register account page
    #When User enter details in below fields
    #|firstName	|Vikash					|
    #|lastName		|Kumar					|
    #|email			|vik1@gmail.com	|
    #|telephone	|9988774455			|
    #|password		|manpur					|
    #|confirmPass|manpur					|
    #And User selects newsletter option
    #And User selects privacy policy
    #And User click on continue button
    #Then User account should be created successfully
    #
#
  Scenario: User create an account with duplicate email
    Given User navigates to Register account page
    When User enter details in below fields
    
    |firstName	|Vikash					|
    |lastName		|Kumar					|
    |email			|vik1@gmail.com	|
    |telephone	|9988774455			|
    |password		|manpur					|
    
    And User selects privacy policy
    And User click on continue button
    Then User should get error message for duplicate email
    
  Scenario: User create an account without filling any details
    Given User navigates to Register account page
    When User dont enter any details
    And User click on continue button
    Then User should get error message for blank value

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |

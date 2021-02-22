@smoke
Feature: User should be able to login

  Scenario: Login with valid data
    Given the user is on the login page
    When the user enters valid information
    Then the user should be able to login

  Scenario: Login with invalid data
    Given the user is on the login page
    When the user enters invalid information
    Then the user should not be able to login
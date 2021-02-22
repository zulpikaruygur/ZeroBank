Feature: Navigating to specific accounts in Accounts Activity
  Scenario Outline: <account name> account redirect
    Given user login with valid data
    When the user clicks on "<account name>" link on the Account Summary page
    Then the title should be Zero - Account Activity
    And Account drop down should have "<account name>" selected

    Examples:
      | account name |
      | Savings      |
      | Brokerage    |
      | Checking     |
      | Credit Card  |
      | Loan         |



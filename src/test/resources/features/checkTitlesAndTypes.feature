Feature: Check titles and account types

  Scenario Outline: Check Account Types
    Given user login with valid data
    When the user go to dashboard
    Then there should be "<account types>"

    Examples:
      | account types       |
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario Outline: Check credit accounts
    Given user login with valid data
    When the user go to dashboard
    Then credit accounts should have "<columns>"

    Examples:
      | columns     |
      | Account     |
      | Credit Card |
      | Balance     |


  Scenario: Check title--Account Activities
    Given user login with valid data
    When the user go to dashboard
    And the user click Account activity
    Then the title should be "Zero - Account Activity"

  Scenario: Drop down default option
    Given user login with valid data
    When the user click Account activity
    Then account dropdown default option should be "Savings"

  Scenario: Drop down all options
    Given user login with valid data
    When the user click Account activity
    Then account dropdown options should be full

  #driver close didn't work properly.
  Scenario Outline: Check Transaction table
    Given user login with valid data
    When the user click Account activity
    Then transaction table should have "<columns>"

    Examples:
      | columns     |
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
Feature: Pay bills
  #comparison failure, maybe charset confiliction. I solved this problem
  # by retyping "-" symbol on keyboard.
  Scenario: Check page title
    Given user login with valid data
    When user click pay bills
    Then the page title should be Zero - Pay Bills

  Scenario: Payment successful message
    Given user login with valid data
    When user click pay bills
    And user enter payment information and sumbit
    Then payment successful message display

  Scenario: Payment unsuccessful message
    Given user login with valid data
    When user click pay bills
    And user doesn't enter payment information and sumbit
    Then payment unsuccessful message display
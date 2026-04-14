Feature: Login Test

  Scenario: Valid Login
    Given user is on SauceDemo login page
    When user enters valid credentials
    Then user should land on inventory page
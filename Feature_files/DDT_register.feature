Feature: Account Registration through DDT

  @sanity @regression
  Scenario: Data driven registration
    Given the user on the registration page
    When the user entered random data from Randomstringutils class
    And the user clicked on checkbox
    And the user clicked on submit button
    Then the user account should get created

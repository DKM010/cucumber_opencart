Feature: Account Registration
@regression @sanity
  Scenario: Successful Account Registration
    Given the user navigates to Register Account page
    When the user enters the details from the below fields
      | firstName | John                 |
      | lastName  | Kenedy               |
      | gmail     | johnnnnhhh@gmail.com |
      | telephone |           7748487487 |
      | password  | test@123             |
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully

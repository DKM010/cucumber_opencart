Feature: Account login

  Scenario Outline: login with valid and invalid data
    Given the user on the login page
    When user enters email as "<email>" and password as "<password>"
    And the user clicked on the login button
    Then login should be successfull

    Examples: 
      | email                     | password |
      | dilipmohapatra8@gmail.com | test@123 |
      | laks@yahoo.com            | xyz      |

  


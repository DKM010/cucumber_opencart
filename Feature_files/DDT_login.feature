Feature: DDT_LOGIN

  Scenario Outline: DDT login from excel sheet
    Given the user on the login page
    Then the user redirected to myaccount page by entering the data by passing the index value as  "<index_no>"
    Examples: 
      | index_no |
      |        1 |
      |        2 |
      |        3 |

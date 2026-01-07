Feature: login feature

  Scenario Outline: Login with valid and invalid credentials from excel
    Given user is on login page
    When   When user login using excel <rownum>
    Then User should login successfully

    Examples:
    |rownum|
    |1     |
    |2     |
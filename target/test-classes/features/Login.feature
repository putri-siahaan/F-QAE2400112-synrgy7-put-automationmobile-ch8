@Login
Feature: Login

  @positive-test
  Scenario: Verify Success Login with valid username and password
    Given user open the app and go to the login page
    And user input valid username with "standard_user"
    And user input valid password with "secret_sauce"
    When user click login button
    Then user is on homepage
    And user is able to see all products

  @negative-test
  Scenario: Verify Failed Login because input invalid password
    Given user open the app and go to the login page
    And user input valid username with "standard_user"
    And user input invalid password with "12345"
    When user click login button
    Then user is on the login page
    And user is able to see error message "Username and password do not match any user in this service."
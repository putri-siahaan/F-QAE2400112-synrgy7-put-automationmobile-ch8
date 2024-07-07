@Checkout
Feature: Checkout Functionality

  Scenario: Verification Successfully completing a checkout process
    Given user login with used valid username and password
    And user added the first product to the cart
    And user added the second product to the cart
    And user click cart icon
    And user click checkout button
    And user input First Name, Last Name, and Postal Code in the information checkout
    And user click continue button
    When user click finish button
    Then validate success checkout

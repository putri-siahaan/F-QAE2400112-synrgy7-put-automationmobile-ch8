@SortingItem
Feature: Sorting Item

  @positive-test
  Scenario: Verification successfully sorts items from lowest to highest price
    Given user login with valid username and password
    And user click the filter button
    When user choose price from low to high option
    Then validate the price of the item on the left is lower than the price of the item on the right

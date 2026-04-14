Feature: Shopping cart on SauceDemo

  Background:
    Given Alice is on the SauceDemo login page

  @cart
  Scenario: Add two products and verify cart counter and contents
    When she logs in with username "standard_user" and password "secret_sauce"
    And she adds the product "Sauce Labs Backpack" to the cart
    And she adds the product "Sauce Labs Bike Light" to the cart
    Then the cart icon should display "2"
    And the cart should contain "Sauce Labs Backpack" and "Sauce Labs Bike Light"

  @cart
  Scenario: Remove one product from cart with two products
    When she logs in with username "standard_user" and password "secret_sauce"
    And she adds the product "Sauce Labs Backpack" to the cart
    And she adds the product "Sauce Labs Bike Light" to the cart
    And she removes the product "Sauce Labs Backpack" from the cart
    Then the cart icon should display "1"
    And the cart should only contain "Sauce Labs Bike Light"
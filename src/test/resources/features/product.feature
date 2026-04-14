Feature: Product catalog on SauceDemo

  Background:
    Given Alice is on the SauceDemo login page

  @products
  Scenario: Sort products by price high to low and verify first and last product
    When she logs in with username "standard_user" and password "secret_sauce"
    And she sorts the products by "Price (high to low)"
    Then the first product should have price "$49.99"
    And the last product should have price "$7.99"

  @products
  Scenario: Verify product detail page content
    When she logs in with username "standard_user" and password "secret_sauce"
    And she clicks on the product "Sauce Labs Backpack"
    Then she should see the product name "Sauce Labs Backpack"
    And she should see the product price "$29.99"
    And she should see the Add to cart button
@saucedemo
Feature: Login on SauceDemo
  As a registered customer
  I want to log in to the Sauce Demo store
  So that I can access the product catalog

  Background:
    Given Alice is on the SauceDemo login page

  @login
  Scenario: Successful login with valid credentials
    When she logs in with username "standard_user" and password "secret_sauce"
    Then she should be redirect to the inventory page
    And she should see the page title "Products"

  @login @negative
  Scenario: Failed login with a locked out user
    When she logs in with username "locked_out_user" and password "secret_sauce"
    Then she should see the error message "Epic sadface: Sorry, this user has been locked out."
    And she should remain on the login page


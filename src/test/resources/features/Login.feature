@login @regression
Feature: Webdriver University - Login Page

  Background:
    Given User is on webdriver university login page

  Scenario Outline: Validate Successful/Unsuccessful Login
    When User enter username <username>
    And User enter password <password>
    And User click login button
    Then User will be represented with <login_message>
    Examples:
      | username   | password      | login_message        |
      | webdriver  | webdriver123  | validation succeeded |
      | webdriver1 | webdriver123  | validation failed    |
      | webdriver  | webdriver1234 | validation failed    |
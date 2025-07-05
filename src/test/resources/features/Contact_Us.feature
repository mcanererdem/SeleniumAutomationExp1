@contact-us @regression
Feature: Webdriver University - Contact Us Page

  Scenario: Validate Successful Contact Us - Unique Data
    Given User is on webdriver university contact us page
    When User enter firstname
    And User enter lastname
    And User enter email address
    And User enter comment
    And User click submit button
    Then User will be represented with successful contact us submission message

  Scenario: Validate Successful Contact Us - Specific Data
    Given User is on webdriver university contact us page
    When User enter a specific firstname as John
    And User enter a specific lastname as Doe
    And User enter a specific email address as JohnDoe@mail.com
    And User enter a specific comment as "This is a good contac us page!"
    And User click submit button
    Then User will be navigated and represented with successful submission message
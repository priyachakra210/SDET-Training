Feature: TextBox option tests


  @sanitytest
  Scenario Outline: Testing textbox elements
    Given I have open the browser
    And I am navigating to the site <URL>
    When I click on textbox option
    And I enter all the textbox details and take screenshot as <ScreenshotName>
    Then I quit the application

    Examples:
      | URL                             | ScreenshotName   |
      | https://www.demoqa.com/elements | screenTextbox100 |
#      | https://www.demoqa.com/elements | screenTextbox200 |

  @datawithoutheader
  Scenario: Testing textbox element using data table1 without headers
    Given I have open the browser
    And I am navigating to the application
      | https://www.demoqa.com/elements |
    When I click on textbox option
    And I enter all the textbox details and take screenshot as dataTable_without_header
    Then I quit the application

  @datawithheader
  Scenario: Testing textbox element using data table1 without headers
    Given I have open the browser
    And I am navigating to the application with headers
      | URL                             |
      | https://www.demoqa.com/elements |
    When I click on textbox option
    And I enter all the textbox details and take screenshot as dataTable_with_header
    Then I quit the application








Feature: TextBox option tests

  @smoketest
  Scenario Outline: Testing textbox elements
    Given I have open the browser
    And I am navigating to the site <URL>
    When I click on button option
    And I click button options and take screenshot as <ScreenshotName>
    Then I quit the application

  Examples:
    | URL                             | ScreenshotName   |
    | https://www.demoqa.com/elements | buttonscreenshot |
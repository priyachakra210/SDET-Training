Feature: Buttonpage tests
@SmokeTest
Scenario Outline: testing textBox elements
  Given I am navigatting to the <URI>
  And  I click on the Buttons option
  Then I See three buttons page
  And I click on the double click me button
  And I click on the Right click me button
  And I click on Click me button
  Then I close the Window
  Examples:
    | URI                             |
    | https://www.demoqa.com/elements |

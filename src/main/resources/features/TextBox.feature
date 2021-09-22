Feature:TextBox option tests
@smoketest @TextBox
  Scenario Outline: testing textBox elements
    Given I am navigatting to the <URI>
    When  i clicking on the textbox element
    And I entered the all the details of textbox page
    Then I cilick on the submmit button
    Then I close the Browser

    Examples:
      | URI                             |
      | https://www.demoqa.com/elements |





$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/textbox.feature");
formatter.feature({
  "name": "TextBox option tests",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testing textbox element using data table1 without headers",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@datawithheader"
    }
  ]
});
formatter.step({
  "name": "I have open the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Steps.iOpenBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am navigating to the application with headers",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.iAmNavigatingToTheApplicationWithHeaders(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on textbox option",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Steps.iClickOnTextboxOption()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter all the textbox details and take screenshot as dataTable_with_header",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.iEnterAllTheTextboxDetails(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I quit the application",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Steps.iQuitTheApplication()"
});
formatter.result({
  "status": "passed"
});
});
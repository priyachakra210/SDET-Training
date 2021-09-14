$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/button.feature");
formatter.feature({
  "name": "TextBox option tests",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Testing textbox elements",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoketest"
    }
  ]
});
formatter.step({
  "name": "I have open the browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I am navigating to the site \u003cURL\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I click on button option",
  "keyword": "When "
});
formatter.step({
  "name": "I click button options and take screenshot as \u003cScreenshotName\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I quit the application",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "URL",
        "ScreenshotName"
      ]
    },
    {
      "cells": [
        "https://www.demoqa.com/elements",
        "buttonscreenshot"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Testing textbox elements",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoketest"
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
  "name": "I am navigating to the site https://www.demoqa.com/elements",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on button option",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Steps.iClickOnButtonOption()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click button options and take screenshot as buttonscreenshot",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.clickingButtonOptions(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I quit the application",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Steps.iQuitTheApplication()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("file:src/main/resources/features/textbox.feature");
formatter.feature({
  "name": "TextBox option tests",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Testing textbox elements",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sanitytest"
    }
  ]
});
formatter.step({
  "name": "I have open the browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I am navigating to the site",
  "keyword": "And "
});
formatter.step({
  "name": "I click on textbox option",
  "keyword": "When "
});
formatter.step({
  "name": "I enter all the textbox details and take screenshot as \u003cScreenshotName\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I quit the application",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "ScreenshotName"
      ]
    },
    {
      "cells": [
        "screenTextbox100"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Testing textbox elements",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sanitytest"
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
  "name": "I am navigating to the site",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.iAmNavigatingToTheURL()"
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
  "name": "I enter all the textbox details and take screenshot as screenTextbox100",
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
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/regresAPI.feature");
formatter.feature({
  "name": "Creating smoke test for regres.in API calls tests",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Creating GET Call for Single User",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smokeapi"
    }
  ]
});
formatter.step({
  "name": "I am baseURI of the regres application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.RegresSteps.iAmBaseURIOfTheApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I passing endpoints for single user",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.RegresSteps.iPassingEndpointsForSingleUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the Status code as 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.RegresSteps.iValidateTheStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the email as janet.weaver@reqres.in",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.RegresSteps.iValidateTheEmailAsJanetWeaverReqresIn(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating POST Call for Single User",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smokeapi"
    }
  ]
});
formatter.step({
  "name": "I am baseURI of the regres application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.RegresSteps.iAmBaseURIOfTheApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I passing endpoints for create user",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.RegresSteps.iPassingEndpointsForCreateUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the Status code as 201",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.RegresSteps.iValidateTheStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the name as morpheus",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.RegresSteps.iValidateTheNameAsMorpheus(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});
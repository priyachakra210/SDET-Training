Feature: Creating smoke test for regres.in API callcle

  @smokeapi
  Scenario: Creating GET Call for Single User
    Given I am baseURI of the regres application
    When I passing endpoints for single user
    Then I validate the Status code as 200
    And I validate the email as janet.weaver@reqres.in


  @smokeapi
  Scenario: Creating POST Call for Single User
    Given I am baseURI of the regres application
    When I passing endpoints for create user
    Then I validate the Status code as 201
    And I validate the name as morpheus

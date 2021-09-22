Feature: creating smoke test for regress.in ApI calls
  @ApiTesting
  Scenario:creating getcall for single user
    Given I am in baseURI
    When I passing endpoint for singleuser
    Then I validate the status code
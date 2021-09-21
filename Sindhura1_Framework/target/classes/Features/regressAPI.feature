Feature: Creating smoke test for reqres.in

  @smoketest
    @TC001
  Scenario: Creating get call for Single user
    Given Im sending baseURI of application
    When Im passing endpoint of single user
    Then I validate the status code as 200
    And I validate for firstname as Janet

  @smoketest
    @TC002
  Scenario: Creating get call for List of users
    Given Im sending baseURI of application
    When Im passing endpoint of list of user
    Then I validate the status code as 200
  # And I validating for firstID , secondEmail, LastFirstname as 7, lindsay.ferguson@reqres.in, Rachel
   And I validating for firstID as 7

  @smoketest
  @TC003
  Scenario: Creating Post call for Single user
    Given Im sending baseURI of application
    When Im passing endpoint of post call for single user
    Then I validate the status code as 201
    And I validate for namevalue as morpheus

  @smoketest
  @TC004
  Scenario: Creating Post call for register
    Given Im sending baseURI of application
    When Im passing endpoint of post call for register
    Then I validate the status code as 200

  @smoketest
  @TC005
  Scenario: Creating put call for Single user
    Given Im sending baseURI of application
    When Im passing endpoint of put call for single user
    Then I validate the status code as 200
    And I validate for jobvalue as zion resident

  @smoketest
  @TC006
  Scenario: Creating delete call for Single user
    Given Im sending baseURI of application
    When Im passing endpoint of delete call for single user
    Then I validate the status code as 204


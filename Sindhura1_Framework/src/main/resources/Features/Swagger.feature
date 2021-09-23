Feature: Creating Sanity Test for swagger petstore

  @sanitytest
  @TC001
  Scenario: Creating post call for new pet
    Given Im sending swaggerURI of application
    When Im setting the values for the parameters for new pet
    And Im passing endpoint for adding new pet
    Then Im validating the status code as 201

  @sanitytest
  @TC002
  Scenario: Creating post call for list of users
    Given Im sending swaggerURI of application
    When Im setting the values for the parameters for list of users
    And Im passing endpoint for list of users
    Then Im validating the status code as 201


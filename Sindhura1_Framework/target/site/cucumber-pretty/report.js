$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/Features/Swagger.feature");
formatter.feature({
  "name": "Creating Sanity Test for swagger petstore",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Creating post call for new pet",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanitytest"
    },
    {
      "name": "@TC001"
    }
  ]
});
formatter.step({
  "name": "Im sending swaggerURI of application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Swaggersteps.imSendingSwaggerAPIOfApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im setting the values for the parameters for new pet",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Swaggersteps.imSettingTheValuesForTheParametersForNewPet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im passing endpoint for adding new pet",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Swaggersteps.imPassingEndpointForAddingNewPet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im validating the status code as 201",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Swaggersteps.imValidatingTheStatusCodeAs(int)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [201] but found [200]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:136)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:839)\r\n\tat org.testng.Assert.assertEquals(Assert.java:849)\r\n\tat stepDefinitions.Swaggersteps.imValidatingTheStatusCodeAs(Swaggersteps.java:127)\r\n\tat ✽.Im validating the status code as 201(file:///C:/Sindhura1_Respository/SDET-Training/Sindhura1_Framework/src/main/resources/Features/Swagger.feature:9)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Creating post call for list of users",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanitytest"
    },
    {
      "name": "@TC002"
    }
  ]
});
formatter.step({
  "name": "Im sending swaggerURI of application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Swaggersteps.imSendingSwaggerAPIOfApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im setting the values for the parameters for list of users",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Swaggersteps.imSettingTheValuesForTheParametersForListOfUsers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im passing endpoint for list of users",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Swaggersteps.imPassingEndpointForListOfUsers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im validating the status code as 201",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Swaggersteps.imValidatingTheStatusCodeAs(int)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [201] but found [200]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:136)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:839)\r\n\tat org.testng.Assert.assertEquals(Assert.java:849)\r\n\tat stepDefinitions.Swaggersteps.imValidatingTheStatusCodeAs(Swaggersteps.java:127)\r\n\tat ✽.Im validating the status code as 201(file:///C:/Sindhura1_Respository/SDET-Training/Sindhura1_Framework/src/main/resources/Features/Swagger.feature:17)\r\n",
  "status": "failed"
});
});
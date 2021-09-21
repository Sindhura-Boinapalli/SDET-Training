$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/Features/regressAPI.feature");
formatter.feature({
  "name": "Creating smoke test for reqres.in",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Creating get call for Single user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoketest"
    },
    {
      "name": "@TC001"
    }
  ]
});
formatter.step({
  "name": "Im sending baseURI of application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imSendingBaseURIOfApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im passing endpoint of single user",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imPassingEndpointOfSingleUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the status code as 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateTheStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate for firstname as Janet",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateForFirstname(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating get call for List of users",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoketest"
    },
    {
      "name": "@TC002"
    }
  ]
});
formatter.step({
  "name": "Im sending baseURI of application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imSendingBaseURIOfApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im passing endpoint of list of user",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imPassingEndpointOfListOfUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the status code as 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateTheStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validating for firstID as 7",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidatingForFirstIDAs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating Post call for Single user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoketest"
    },
    {
      "name": "@TC003"
    }
  ]
});
formatter.step({
  "name": "Im sending baseURI of application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imSendingBaseURIOfApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im passing endpoint of post call for single user",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imPassingEndpointOfPostCallForSingleUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the status code as 201",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateTheStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate for namevalue as morpheus",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateForNamevalueAs(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating Post call for register",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoketest"
    },
    {
      "name": "@TC004"
    }
  ]
});
formatter.step({
  "name": "Im sending baseURI of application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imSendingBaseURIOfApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im passing endpoint of post call for register",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imPassingEndpointOfPostCallForRegister()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the status code as 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateTheStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating put call for Single user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoketest"
    },
    {
      "name": "@TC005"
    }
  ]
});
formatter.step({
  "name": "Im sending baseURI of application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imSendingBaseURIOfApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im passing endpoint of put call for single user",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imPassingEndpointOfPutCallForSingleUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the status code as 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateTheStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate for jobvalue as zion resident",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateForJobvalueAs(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating delete call for Single user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoketest"
    },
    {
      "name": "@TC006"
    }
  ]
});
formatter.step({
  "name": "Im sending baseURI of application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imSendingBaseURIOfApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Im passing endpoint of delete call for single user",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.imPassingEndpointOfDeleteCallForSingleUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the status code as 204",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.regressSteps.iValidateTheStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
});
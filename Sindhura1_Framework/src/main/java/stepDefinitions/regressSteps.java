package stepDefinitions;

import Base.Filereadermanager;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import pojos.Postpojo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class regressSteps {

    Response response;
    Postpojo postpojo;

    @Given("Im sending baseURI of application")
    public void imSendingBaseURIOfApplication() throws IOException {

        Filereadermanager filereadermanager=new Filereadermanager();
        RestAssured.baseURI = filereadermanager.getProperties("baseURI");

    }

    @When("Im passing endpoint of single user")
    public void imPassingEndpointOfSingleUser() {
         response=  given().
                when().
                header("Content-Type","application/json")
                .get("api/users/2");
    }

    @Then("^I validate the status code as (.*)$")
    public void iValidateTheStatusCode(int expectedcode) {

         Assert.assertEquals(response.getStatusCode(),expectedcode);
    }

    @And("^I validate for firstname as (.*)$")
    public void iValidateForFirstname(String expected_firstname) {
        String responseBody = response.getBody().asString();
        String actual_firstname = JsonPath.read(responseBody,"$.data.first_name");
        Assert.assertEquals(actual_firstname,expected_firstname);
    }

    @When("Im passing endpoint of list of user")
    public void imPassingEndpointOfListOfUser()
    {
        response=  given().
                when().
                header("Content-Type","application/json")
                .get("api/users?page=2");

    }

    @And("^I validating for firstID as (.*)$")
    public void iValidatingForFirstIDAs(int expectedfirstID)
    {
        String responseBody = response.getBody().asString();

        int actualfirstID = JsonPath.read(responseBody,"$.data[0].id");
        Assert.assertEquals(actualfirstID,expectedfirstID);

    }

    @When("Im passing endpoint of post call for single user")
    public void imPassingEndpointOfPostCallForSingleUser()
    {
        postpojo= new Postpojo();

        postpojo.setName("morpheus");
        postpojo.setJob("leader");

        response = given().
                when().
                header("Content-Type","application/json").
                body(postpojo).
                post("api/users");
    }

    @And("^I validate for namevalue as (.*)$")
    public void iValidateForNamevalueAs(String expectednamevalue)
    {
        String responseBody = response.getBody().asString();
        String actualnamevalue = JsonPath.read(responseBody,"$.name");
        Assert.assertEquals(actualnamevalue,expectednamevalue);
    }

    @When("Im passing endpoint of put call for single user")
    public void imPassingEndpointOfPutCallForSingleUser()
    {
        Map<String,String> bodyparm = new HashMap<>();
        bodyparm.put("name","morpheus");
        bodyparm.put("job","zion resident");

        response = given().
                when().
                header("Content-Type","application/json").
                body(bodyparm).
                put("api/users");
    }

    @And("^I validate for jobvalue as (.*)$")
    public void iValidateForJobvalueAs(String expectedjobvalue)
    {
        String responseBody = response.getBody().asString();
        String actualjobvalue = JsonPath.read(responseBody,"$.job");
        Assert.assertEquals(actualjobvalue,expectedjobvalue);
    }

    @When("Im passing endpoint of delete call for single user")
    public void imPassingEndpointOfDeleteCallForSingleUser()
    {
        response = given().
                when().
                header("Content-Type","application/json").
                delete("api/users/2");
    }

    @When("Im passing endpoint of post call for register")
    public void imPassingEndpointOfPostCallForRegister()
    {
        postpojo= new Postpojo();

        postpojo.setEmail("eve.holt@reqres.in");
        postpojo.setPassword("pistol");

        response = given().
                when().
                header("Content-Type","application/json").
                body(postpojo).
                post("api/register");
    }

        /*@And("^I validating for firstID , secondEmail, LastFirstname (.*)$")
    public void iValidatingForFirstIDSecondEmailLastFirstname(int expectedfirstID, String expectedsecondEmail, String expectedLastFirstname)
    {
        String responseBody = response.getBody().asString();

        int actualfirstID = JsonPath.read(responseBody,"$.data[0].id");
        Assert.assertEquals(actualfirstID,expectedfirstID);

        String actualsecondEmail = JsonPath.read(responseBody,"$.data[1].email");
        Assert.assertEquals(actualfirstID,expectedsecondEmail);

        String actualLastFirstname = JsonPath.read(responseBody,"$.data[5].first_name");
        Assert.assertEquals(actualfirstID,expectedLastFirstname);

    }*/


}

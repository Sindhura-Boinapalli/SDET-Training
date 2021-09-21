package stepDefinitions;

import Base.Filereadermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import pojos.SwaggerArrayPost.ArrayPojo;
import pojos.SwaggerArrayPost.Parameters;
import pojos.SwaggerPost.Category;
import pojos.SwaggerPost.SwaggerPojo;
import pojos.SwaggerPost.Tags;
import pojos.SwaggerUpdate.UpdatePojo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Swaggersteps
{

    SwaggerPojo swaggerPojo;
    Category category;
    Tags tags;
    Parameters parameters;
    ArrayPojo arrayPojo;
    Response response;
    UpdatePojo updatePojo;



    @Given("Im sending swaggerURI of application")
    public void imSendingSwaggerAPIOfApplication() throws IOException {
        Filereadermanager filereadermanager=new Filereadermanager();
        RestAssured.baseURI = filereadermanager.getProperties("swaggerURI");

    }


    @When("Im setting the values for the parameters for new pet")
    public void imSettingTheValuesForTheParametersForNewPet()
    {
        swaggerPojo = new SwaggerPojo();
        category = new Category();
        tags = new Tags();


        //Setting values for category class
        category.setId(2);
        category.setName("doggy");

        //Creating list for tags and setting values
        tags.setId(3);
        tags.setName("Doggypuppy");
        List<Tags> tagsList = new ArrayList<>();
        tagsList.add(tags);

        //Creatng list for photourl
        List<String> photolist = new ArrayList<>();
        photolist.add("String");

        //setting values for swagger root pojo
        swaggerPojo.setId(0);
        swaggerPojo.setName("puppy");
        swaggerPojo.setStatus("Active");
        swaggerPojo.setTags(tagsList);
        swaggerPojo.setPhotoUrls(photolist);
        swaggerPojo.setCategory(category);

    }

    @And("Im passing endpoint for adding new pet")
    public void imPassingEndpointForAddingNewPet()
    {
        response = given().
                when().
                header("Content-Type","application/json").
                body(swaggerPojo).
                post("/v2/pet");


    }

       @When("Im setting the values for the parameters for list of users")
    public void imSettingTheValuesForTheParametersForListOfUsers()
    {
        arrayPojo = new ArrayPojo();
        parameters = new Parameters();

        //Setting parameter values
        parameters.setId(100);
        parameters.setUsername("ABCD");
        parameters.setFirstName("Sindhura1");
        parameters.setLastName("Boinapalli");
        parameters.setEmail("xyz@gmail.com");
        parameters.setPassword("*****");
        parameters.setPhone("1234567890");
        parameters.setUserStatus(1);

        //Creating list for parameterlist
        List<Parameters> parametersList = new ArrayList<>();
        parametersList.add(parameters);

        //Set list to arraypojo
        arrayPojo.setParametersList(parametersList);
    }

    @And("Im passing endpoint for list of users")
    public void imPassingEndpointForListOfUsers()
    {
        response = given().
                when().
                header("Content-Type","application/json").
                body(arrayPojo.getParametersList()).
                post("/v2/user/createWithArray");
    }


    @Then("^Im validating the status code as (.*)$")
    public void imValidatingTheStatusCodeAs(int expectedcode) {

        Assert.assertEquals(response.getStatusCode(),expectedcode);
    }


}

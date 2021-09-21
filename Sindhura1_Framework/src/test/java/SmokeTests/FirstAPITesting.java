package SmokeTests;

import Base.baseAPI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.Postpojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FirstAPITesting extends baseAPI
{

    //Creating object for log4J
    Logger logger = Logger.getLogger(FirstAPITesting.class);

    //Creating objects for extent reports
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    //Creating
    Postpojo postpojo;


    @BeforeTest
    public void setUp()
    {
        PropertyConfigurator.configure("src/main/resources/properties/log4j.properties");

        // start reporters
        htmlReporter = new ExtentHtmlReporter("target/Sindhura1_API_Report.html");

        //append the report
        htmlReporter.setAppendExisting(true);


        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        test = extent.createTest("Put Call","Using Postman");
    }

    @Test(priority=0)
    public void getCallSingleUser()
    {
        Response response=  given().
                            when().
                            header("Content-Type","application/json")
                            .get("api/users/2");

        String responseBody = response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(),200);

        String firstname = JsonPath.read(responseBody,"$.data.first_name");
        Assert.assertEquals(firstname,"Janet");

        System.out.println(responseBody);
    }

    @Test
    public void getCallforListusers()
    {
        Response response=  given().
                when().
                header("Content-Type","application/json")
                .get("api/users?page=2");

        String responseBody = response.getBody().asString();

        int firstID = JsonPath.read(responseBody,"$.data[0].id");
        Assert.assertEquals(firstID,7);

        String secondEmail = JsonPath.read(responseBody,"$.data[1].email");
        Assert.assertEquals(secondEmail,"lindsay.ferguson@reqres.in");

        String LastFirstname = JsonPath.read(responseBody,"$.data[5].first_name");
        Assert.assertEquals(LastFirstname,"Rachel");

        System.out.println(responseBody);
    }

    @Test(priority=1)
    public void postCall()
    {
        postpojo= new Postpojo();

        postpojo.setName("morpheus");
        postpojo.setJob("leader");

        Response response = given().
                            when().
                            header("Content-Type","application/json").
                            body(postpojo).
                            post("api/users");

        String responseBody = response.getBody().asString();

        Assert.assertEquals(response.getStatusCode(),201);

        System.out.println(response.getStatusCode());
        String namevalue = JsonPath.read(responseBody,"$.name");
        Assert.assertEquals(namevalue,"morpheus");
        System.out.println(responseBody);
    }

    @Test(priority=2)
    public void putCall()
    {
        Map<String,String> bodyparm = new HashMap<>();
        bodyparm.put("name","morpheus");
        bodyparm.put("job","zion resident");

      test.log(Status.INFO, "Performing the put call");

        Response response = given().
                when().
                header("Content-Type","application/json").
                body(bodyparm).
                put("api/users");

        logger.warn("Successfully updated the user job");

        test.log(Status.PASS, "Successfully updated the user job");

        String responseBody = response.getBody().asString();
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(responseBody);
    }

    @Test(priority=3)
    public void deleteCall()
    {
        PropertyConfigurator.configure("src/main/resources/properties/log4j.properties");

        Response response = given().
                when().
                header("Content-Type","application/json").
                delete("api/users/2");


        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),204);

        logger.warn("Successfully deleted");
    }

    @AfterTest
    public void teardown()
    {
        extent.flush();

    }
}

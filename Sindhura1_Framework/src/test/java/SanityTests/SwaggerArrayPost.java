package SanityTests;

import Base.SwaggerbaseAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.SwaggerArrayPost.ArrayPojo;
import pojos.SwaggerArrayPost.Parameters;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SwaggerArrayPost extends SwaggerbaseAPI
{
    Parameters parameters;
    ArrayPojo arrayPojo;
    Response response;

    @Test
    public void swaggerArraypost()
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

        response = given().
                when().
                header("Content-Type","application/json").
                body(arrayPojo.getParametersList()).
                post("/v2/user/createWithArray");

        String responseBody = response.getBody().asString();

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println(response.getStatusCode());

        System.out.println(responseBody);

    }

}

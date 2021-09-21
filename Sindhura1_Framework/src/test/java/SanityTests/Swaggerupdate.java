package SanityTests;

import Base.SwaggerbaseAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.SwaggerUpdate.UpdatePojo;

import static io.restassured.RestAssured.given;

public class Swaggerupdate extends SwaggerbaseAPI
{

    @Test
    public void swaggerUpdate(UpdatePojo updatePojo)
    {

        String idtopass = updatePojo.getIdfrompost();

        System.out.println(idtopass);
        System.out.println("/v2/pet/"+idtopass);

       Response response = given().
                when().
                header("Content-Type","application/json").
                get("/v2/pet/"+idtopass);

        String responseBody = response.getBody().asString();

        System.out.println(responseBody);

        Assert.assertEquals(response.getStatusCode(),404);

        System.out.println(response.getStatusCode());



    }
}

package SanityTests;

import Base.SwaggerbaseAPI;
import com.jayway.jsonpath.internal.filter.ValueNodes;
import com.mongodb.util.JSON;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pojos.SwaggerPost.Category;
import pojos.SwaggerPost.SwaggerPojo;
import pojos.SwaggerPost.Tags;
import pojos.SwaggerUpdate.UpdatePojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Swaggerpost extends SwaggerbaseAPI
{

    SwaggerPojo swaggerPojo;
    Category category;
    Tags tags;
    Response response;
    UpdatePojo updatePojo;

    @Test
    public void swaggerpost()
    {
        swaggerPojo = new SwaggerPojo();
        category = new Category();
        tags = new Tags();

        updatePojo = new UpdatePojo();

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


         response = given().
                when().
                header("Content-Type","application/json").
                body(swaggerPojo).
                post("/v2/pet");

        String responseBody = response.getBody().asString();

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println(response.getStatusCode());

        System.out.println(responseBody);

        String responseID[] = responseBody.split(":");

        String IDresponse = (responseID[1].replace(",\"category\"","" ));

        System.out.println(IDresponse);

        updatePojo.setIdfrompost(IDresponse);

        System.out.println(updatePojo.getIdfrompost());

        Swaggerupdate swaggerupdate = new Swaggerupdate();
        swaggerupdate.swaggerUpdate(updatePojo);
            }

}

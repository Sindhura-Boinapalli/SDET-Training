package Base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class baseAPI
{
    Filereadermanager filereadermanager;


    @BeforeClass


    public void Base() throws IOException {
        filereadermanager=new Filereadermanager();
        RestAssured.baseURI = filereadermanager.getProperties("baseURI");

    }
}

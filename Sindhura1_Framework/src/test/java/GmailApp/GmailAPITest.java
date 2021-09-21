package GmailApp;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GmailAPITest
{
    String accesstoken = "Bearer ya29.a0ARrdaM9zsyhVj4D2-cSdKpG-mT1zkl4CtEd40odMorpbK6hRzLfFZ9LdhVRU1HcrUtRhryrTcVCMl1nXKkcv9s6Fnfequewy3N9pcDc9aitK8jV70qJAhRp8hS97CRL3wP35H_9FYcsSku50NsDlkLrEQor-";

    @Test
    public void gmailAPITest()
    {
        String msg = "From: bonepalli.sivaramakrishna@gmail.com\n" +
                "To: bonepalli.sivaramakrishna@gmail.com\n" +
                "Subject: Test Email from Rest Assured\n" +
                "\n" +
                "Sending from Gmail API";

        String base64URLencoded = Base64.getUrlEncoder().encodeToString(msg.getBytes());

        Map<String,String> payload = new HashMap<>();
        payload.put("raw",base64URLencoded);

        Response response = given().
                when().
                header("Content-Type","application/json").
                header("Authorization",accesstoken).
                body(payload).
                post("https://gmail.googleapis.com/gmail/v1/users/bonepalli.sivaramakrishna@gmail.com/messages/send");

        String responseBody = response.getBody().asString();

        System.out.println(responseBody);

    }
}

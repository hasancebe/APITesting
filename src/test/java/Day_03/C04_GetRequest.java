package Day_03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class C04_GetRequest {
    public C04_GetRequest() {
    }

    @Test
    public void userReqresID3Exist() {
       // Response response = (Response)RestAssured.given().when().get(BaseUrl.userIDHerokuapp(4), new Object[0]);
      //  response.prettyPrint();
        //((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)response.then()).contentType("application/json")).statusCode(200)).body("data.first_name", Matchers.equalTo("Eve"), new Object[]{"data.last_name", Matchers.equalTo("Holt"), "data.email", Matchers.equalTo("eve.holt@reqres.in"), "support.url", Matchers.equalTo("https://reqres.in/#support-heading"), "support.text", Matchers.equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")});
    }
}

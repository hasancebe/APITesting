package Day_03;

import io.restassured.response.Response;
import org.junit.Test;
import org.openqa.selenium.devtools.v104.fetch.model.AuthChallengeResponse;

import static io.restassured.RestAssured.given;

public class C01_Get_request {
    private String usersReqresIn="https://reqres.in/api/users";
    @Test
    public void gerUsersReqresIn(){
        Response response=given().when().get(usersReqresIn);
       // response.prettyPrint();
        response.then().log().all();
    }
}

package Day_03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class C03_GetRequest {
    private String bookingHerokuapp = "https://restful-booker.herokuapp.com/booking/";
    private String bookingID240Herokuapp = "https://restful-booker.herokuapp.com/booking/240";
    private String userID2ReqresIn = "https://reqres.in/api/users/2";
    private String UserID3ReqresIn = "https://reqres.in/api/users/3";

    public C03_GetRequest() {
    }

    @Test
    public void getBooking() {
        Response response = (Response)RestAssured.given().when().get(this.bookingHerokuapp, new Object[0]);
        response.prettyPeek();
    }

    @Test
    public void bookingIdIsExist() {
        Response response = (Response)RestAssured.given().when().get(this.bookingID240Herokuapp, new Object[0]);
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)response.then()).statusCode(200)).contentType("application/json; charset=utf-8")).body("firstname", Matchers.equalTo("John"), new Object[]{"lastname", Matchers.equalTo("Smith"), "totalprice", Matchers.equalTo(111), "depositpaid", Matchers.equalTo(true), "bookingdates.checkin", Matchers.equalTo("2018-01-01"), "bookingdates.checkout", Matchers.equalTo("2019-01-01")});
    }

    @Test
    public void userReqresID2Exist() {
        Response response = (Response)RestAssured.given().when().get(this.userID2ReqresIn, new Object[0]);
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)response.then()).contentType("application/json")).statusCode(200)).body("data.first_name", Matchers.equalTo("Janet"), new Object[]{"data.last_name", Matchers.equalTo("Weaver"), "data.email", Matchers.equalTo("janet.weaver@reqres.in"), "support.url", Matchers.equalTo("https://reqres.in/#support-heading"), "support.text", Matchers.equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")});
    }

    @Test
    public void userReqresID3Exist() {
        Response response = (Response)RestAssured.given().when().get(this.UserID3ReqresIn, new Object[0]);
        response.prettyPrint();
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)response.then()).contentType("application/json")).statusCode(200)).body("data.first_name", Matchers.equalTo("Emma"), new Object[]{"data.last_name", Matchers.equalTo("Wong"), "data.email", Matchers.equalTo("ema.wong@reqres.in"), "support.url", Matchers.equalTo("https://reqres.in/#support-heading"), "support.text", Matchers.equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")});
    }
}

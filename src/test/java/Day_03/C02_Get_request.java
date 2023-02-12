package Day_03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class C02_Get_request {
    private String restfulBookerUrl = "https://restful-booker.herokuapp.com/booking/10";
    private Response response;

    public C02_Get_request() {
        this.response = (Response)RestAssured.given().when().get(this.restfulBookerUrl, new Object[0]);
    }

    @Test
    public void printInfoRestfulBooker() {
        System.out.println("Status Code is :" + this.response.getStatusCode());
        System.out.println("The Content Type is :" + this.response.contentType());
        System.out.println("The Value of the Header :" + this.response.getHeader("Server"));
        System.out.println("Status Line :" + this.response.statusLine());
        System.out.println("The time of the response :" + this.response.getTime());
    }

    @Test
    public void bookingTestWithAssertion() {
        Assert.assertEquals(this.response.statusCode(), 200);
        Assert.assertEquals(this.response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(this.response.header("Server"), "Cowboy");
        Assert.assertEquals(this.response.statusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void bookingHeaderTest() {

                this.response.then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server", "Cowboy").
                statusLine("HTTP/1.1 200 OK");
    }
}
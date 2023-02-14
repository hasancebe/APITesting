package TurkishClass.Day_01;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class C01_get extends TestBase {
 String restfulBookerUrl = "https://restful-booker.herokuapp.com/booking/10";
    Response response;
/*
    send a Get request to the https://restful-booker.herokuapp.com/booking/10
    verify:
    the status code is 200,
    the content type is application/json; charset=utf-8,
    the value of the Header named Server is Cowboy
    status line is HTTP/1.1 200 OK
    response time is less than 5 second
     */
    @Test
    public void get_RestfulBookerUrl() {
        getUrl(restfulBookerUrl, response);
    }
    @Test
    public  void get_RestfulBooker_Response_Information(){
        get_information_Response(restfulBookerUrl,response);

    }
}

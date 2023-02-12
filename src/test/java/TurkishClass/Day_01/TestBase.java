package TurkishClass.Day_01;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestBase {
    public void getUrl(String url,Response response){
        response=given().when().get(url);
    }

    public void get_information_Response(String url,Response response){
        response=given().when().get(url);
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","Cowboy").
                statusLine("HTTP/1.1 200 OK");

        System.out.println("The time of the response :" + response.getTime());

    }
}

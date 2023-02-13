package utilities;

import io.restassured.response.Response;

import static Day_03.BaseUrl.userIDHerokuapp;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiCalls {
    // This method will return response and we will use MatcherClass
    public static boolean checkUserExistWithId(int id, int statuscode, String email,
                                               String first_name, String last_name ){

        Response response = given().when().get(userIDHerokuapp(id));
        response
                .then()
                .statusCode(statuscode)
                .contentType("application/json")
                .body("data.email", equalTo(email),"data.first_name",equalTo(first_name),
                        "data.last_name",equalTo(last_name)) ;
        return Boolean.parseBoolean(String.valueOf(response));
    }

    public static Response checkUsersExistWithId(int id, int statuscode, String email,
                                                 String first_name, String last_name ) {

        Response response = given().when().get(userIDHerokuapp(id));
        response
                .then()
                .statusCode(statuscode)
                .contentType("application/json")
                .body("data.email", equalTo(email), "data.first_name", equalTo(first_name),
                        "data.last_name", equalTo(last_name));
        return response;
    }



}

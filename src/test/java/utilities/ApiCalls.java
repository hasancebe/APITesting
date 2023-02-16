package utilities;

import Day_03.BaseUrl;
import Day_03.pojo.JsonPlaceHolderPojo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;

import static Day_03.BaseUrl.userIDHerokuapp;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static utilities.BaseUrlInterface.patcjsonplaceholder;

public class ApiCalls extends BaseUrl {
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

    public static Response checkUsersExistsJsonPath(int id, int statuscode, String email,
                                                    String first_name, String last_name){
        Response response = given().when().get(userIDHerokuapp(id));
        response.then().statusCode(statuscode);

        JsonPath jsonPath = response.jsonPath() ;
        Assert.assertEquals(email,jsonPath.getString("data.email"));
        Assert.assertEquals(first_name,jsonPath.getString("data.first_name"));
        Assert.assertEquals(last_name,jsonPath.getString("data.last_name"));
        return response ;
    }





    //********************************************************************************************
    // booking ==>> https://restful-booker.herokuapp.com/booking/
    public static Response checkUsersBookingExistWithId(int id, int statuscode, String firstname,
                                                        String lastname, int totalprice,boolean depositpaid
            ,String checkin,String checkout ) {

        Response response = given().when().get(bookingUserID(id));// https://restful-booker.herokuapp.com/booking/
        response
                .then()
                .statusCode(statuscode)
                .contentType("application/json")
                .body("firstname", equalTo(firstname), "lastname", equalTo(lastname),
                        "totalprice", equalTo(totalprice),"depositpaid",equalTo(depositpaid),
                        "bookingdates.checkin",equalTo(checkin),"bookingdates.checkout",equalTo(checkout));
        return response;
    }


//****** De-Serialization Dynamic Method *************************

    public static Response deSerializationMethod(int id, int statuscode, String firstname,
                                                 String lastname, double totalprice,boolean depositpaid
            ,String checkin,String checkout ){

        HashMap<String , Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin",checkin);
        bookingdates.put("checkout",checkout);
        HashMap<String , Object> expectedData = new HashMap<>();
        expectedData.put("firstname",firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates",bookingdates );

        // Request and Response
        Response response = given().when().get(bookingUserID(id));
        response.then().statusCode(statuscode) ;
        //Convert data from Json to Java  ===>> De-Serialization
        // Convert data from Java to Json ===>> Serialization
        // here Data will be converted to the Map by De-Serialization
        HashMap<String, Object> actualData = response.as(HashMap.class) ;// we did de-serialization

        // Verify
        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(expectedData.get("checkin"),actualData.get("checkin"));
        Assert.assertEquals(expectedData.get("checkout"),actualData.get("checkout"));
        return response ;
    }

    public static  Response patchRequestJsonPlaceHolder(int id,int statuscode,int userId,
                                                        String title, boolean completed){

        JSONObject requestData=new JSONObject();
        requestData.put("title",title);
        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",userId);
        expectedData.put("title",title);
        expectedData.put("completed",completed);
        Response response=given().contentType(ContentType.JSON)
                .body(requestData.toString())
                .when()
                .patch(patcjsonplaceholder(id));
        response.then().assertThat().statusCode(statuscode).body("userId",Matchers.equalTo(1),"title",
                Matchers.equalTo(title),
                "completed",Matchers.equalTo(completed));
        return response;
    }


    public static Response pojoPostJasonPlaceHolder(int id, int statuscode,int userId,
                                                    String title, boolean completed){

        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo();
        expectedData.setId(201);
        expectedData.setUserId(120);
        expectedData.setTitle("Slovenia");
        expectedData.setCompleted(true);

        Response response=given().contentType(ContentType.JSON)
                .body(expectedData)
                .when()
                .post(utilities.BaseUrlInterface.createJsonPlaceHolder());

       response.then().assertThat().statusCode(statuscode);

        JsonPlaceHolderPojo actualData=response.as(JsonPlaceHolderPojo.class);

        Assert.assertEquals(expectedData.getId(),actualData.getId());
        Assert.assertEquals(expectedData.getUserId(),actualData.getUserId());
        Assert.assertEquals(expectedData.getTitle(),actualData.getTitle());
        Assert.assertEquals(expectedData.isCompleted(),actualData.isCompleted());
        return response;
    }
}

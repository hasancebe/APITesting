package TurkishClass.Day_01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C05_Post_ResponseBody_Test {
    @Test
    public void post01(){
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject bodyObj=new JSONObject();
        bodyObj.put("title","API");
        bodyObj.put("body","API ogrenmek ne güzel");
        bodyObj.put("userId",10);
        System.out.println(bodyObj);

        Response response=given().contentType(ContentType.JSON).when().body(bodyObj.toString()).post(url);

        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));

    }
    @Test
    public void post02(){
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject bodyObj=new JSONObject();
        bodyObj.put("title","API");
        bodyObj.put("body","API ogrenmek ne güzel");
        bodyObj.put("userId",10);


        Response response=given().contentType(ContentType.JSON).when().body(bodyObj.toString()).post(url);

        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", equalTo("API"),
                "userId", lessThan(100),
                "body",containsString("API"));

    }
}

package TurkishClass.Day_01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class C03_Put extends TestBase {

    String url="https://jsonplaceholder.typicode.com/posts/70";
    @Test
    public void json_Obj(){
        JSONObject firstObj=new JSONObject();
        firstObj.put("title","Ahmet");
        firstObj.put("body","Hello");
        firstObj.put("userId","10");
        firstObj.put("id",70);
        System.out.println(firstObj);
        Response response= given().contentType(ContentType.JSON).when().body(firstObj.toString()).put(url);
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");
    }
}

package Day_03;

import Day_03.pojo.JsonPlaceHolderPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.ApiCalls;

import static io.restassured.RestAssured.given;

public class C08_PostRequestPojo {
    /*
    {
        "userId": 25,
        "id": 120,
        "title": "slovenia",
        "completed": true
        }
        */

    @Test
    public void pojoTest(){

        ApiCalls.pojoPostJasonPlaceHolder(201,201,120,"Slovenia",true);
    }
}

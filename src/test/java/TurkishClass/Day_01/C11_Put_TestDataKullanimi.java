package TurkishClass.Day_01;

import BaseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C11_Put_TestDataKullanimi extends JsonPlaceHolderBaseUrl {
    @Test
    public void put01(){
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        JSONObject reqData= TestDataJsonPlaceHolder.requestBodyOlusturJSONAli();

        JSONObject expData= TestDataJsonPlaceHolder.requestBodyOlusturJSONAli();

        Response response=given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(reqData.toString()).put("/{pp1}/{pp2}");

        Assert.assertEquals(testDataJsonPlaceHolder.basarilistatus,response.getStatusCode());
        Assert.assertEquals(testDataJsonPlaceHolder.basariliContectType,response.getContentType());
        Assert.assertEquals(testDataJsonPlaceHolder.connectionDegeri,response.getHeader("Connection"));

        JsonPath resJSP=response.jsonPath();
        Assert.assertEquals(expData.get("userId"),resJSP.get("userId"));
        Assert.assertEquals(expData.get("id"),resJSP.get("id"));
        Assert.assertEquals(expData.get("title"),resJSP.get("title"));
        Assert.assertEquals(expData.get("body"),resJSP
                .get("body"));

    }
}

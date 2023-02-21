package TurkishClass.Day_01;

import TurkishClass.Day_01.BaseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C10_GetTestDataKullanimi extends JsonPlaceHolderBaseUrl {
    @Test
    public void get01(){
        specJsonPlace.pathParams("pp1","posts","pp2",22);
        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        JSONObject expData= TestDataJsonPlaceHolder.expectedBodyOlusturJSON();
        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        JsonPath resJpath=response.jsonPath();
        Assert.assertEquals(testDataJsonPlaceHolder.basarilistatus,response.getStatusCode());
        Assert.assertEquals(expData.get("userId"),resJpath.get("userId"));
        Assert.assertEquals(expData.get("id"),resJpath.get("id"));
        Assert.assertEquals(expData.get("title"),resJpath.get("title"));
        Assert.assertEquals(expData.get("body"),resJpath.get("body"));

    }

}

package TurkishClass.Day_01;

import Day_03.BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_GetExpectedDataOlusturma {
    @Test
    public void get01() {
       String url= BaseUrl.userJsonPlaceHolderId( 22);
        JSONObject expBody=new JSONObject();
        expBody.put("userId",2);
        expBody.put("id",22);
        expBody.put("body","eos qui et ipsum ipsam suscipit aut/nsed omnis non odio/nexpedidita earum mollitia molestiae aut atque rem suscipit/nnam impedit esse");

        expBody.put("title","distinctio vitae autem nihil ut molestias quo" );

        System.out.println(expBody);

        Response response=given().when().get(url);
        response.prettyPrint();

        //Assertion
        //response'u jsonpath objesine dönüştürüyoruz.
        JsonPath rspJson=response.jsonPath();
        Assert.assertEquals(expBody.get("userId"),rspJson.getInt("userId"));
        Assert.assertEquals(expBody.get("id"),rspJson.getInt("id"));
        Assert.assertEquals(expBody.get("title"),rspJson.getString("title"));
        //Assert.assertEquals(expBody.get("body"),rspJson.getString("body"));


    }
}
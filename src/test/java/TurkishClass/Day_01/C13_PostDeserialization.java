package TurkishClass.Day_01;

import TurkishClass.Day_01.testData.TestDataHerokuapp;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C13_PostDeserialization extends TurkishClass.Day_01.BaseUrl.HerokuappBaseUrl {
    @Test
    public void post01(){

        specHerokuapp.pathParam("pp1","booking");
        TestDataHerokuapp testDataHerokuapp=new TestDataHerokuapp();
        HashMap<String,Object> reqBody=testDataHerokuapp.bookingOlusturMap();
        HashMap<String,Object>expData=testDataHerokuapp.expbodyolusturMap();
        Response response=given()
                .spec(specHerokuapp).
                when().body(reqBody)
                .post("/{pp1");

        HashMap<String,Object>resMap=response.as(HashMap.class);
        Assert.assertEquals(     ((Map) (expData.get("booking")) ) .get("firstname") ,
                ((Map) (resMap.get("booking")) ) .get("firstname"));

        Assert.assertEquals(     ((Map) (expData.get("booking")) ) .get("lastname") ,
                ((Map) (resMap.get("booking")) ) .get("lastname"));

        Assert.assertEquals(     ((Map) (expData.get("booking")) ) .get("totalprice") ,
                ((Map) (resMap.get("booking")) ) .get("totalprice"));

        Assert.assertEquals(     ((Map) (expData.get("booking")) ) .get("depositname") ,
                ((Map) (resMap.get("booking")) ) .get("depositname"));

        Assert.assertEquals(     ((Map) (expData.get("booking")) ) .get("additionalneeds") ,
                ((Map) (resMap.get("booking")) ) .get("additionalneeds"));

        Assert.assertEquals(       ( (Map)  ( ( (Map)(expData.get("booking"))).get("bookingdates")) ).get("checkin"),
                ( (Map)  ( ( (Map)(resMap.get("booking"))).get("bookingdates")) ).get("checkin")  );

        Assert.assertEquals(       ( (Map)  ( ( (Map)(expData.get("booking"))).get("bookingdates")) ).get("checkout"),
                ( (Map)  ( ( (Map)(resMap.get("booking"))).get("bookingdates")) ).get("checkout")  );
    }

}

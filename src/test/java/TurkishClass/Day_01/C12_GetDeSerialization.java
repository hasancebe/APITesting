package TurkishClass.Day_01;

import TurkishClass.Day_01.testData.TestDataDummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C12_GetDeSerialization extends TurkishClass.Day_01.BaseUrl.DummyBaseUrl {
    @Test
    public void get01(){
        specDummy.pathParams("pp1","employee","pp2",3);
        TestDataDummy testDataDummy=new TestDataDummy();
        HashMap<String ,Object>expData=testDataDummy.expectedBodyMap();
        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");
        //response.prettyPrint();

        //Assertion
        Assert.assertEquals(testDataDummy.basariliststusCod,response.getStatusCode());
        Assert.assertEquals(testDataDummy.contectType,response.getContentType());
        HashMap<String ,Object>resMap=response.as(HashMap.class);
        Assert.assertEquals(expData.get("status"),resMap.get("status"));
        Assert.assertEquals(expData.get("message"),resMap.get("message"));
        Assert.assertEquals(   ( (Map)(expData.get("data"))).get("id"),
                               ( (Map)(resMap.get("data"))).get("id") );

        Assert.assertEquals(   ( (Map)(expData.get("data"))).get("employee_name"),
                               ( (Map)(resMap.get("data"))).get("employee_name") );

        Assert.assertEquals(   ( (Map)(expData.get("data"))).get("employee_salary"),
                            ( (Map)(resMap.get("data"))).get("employee_salary") );

        Assert.assertEquals(   ( (Map)(expData.get("data"))).get("employee_age"),
                             ( (Map)(resMap.get("data"))).get("employee_age") );

        Assert.assertEquals(   ( (Map)(expData.get("data"))).get("profile_image"),
                             ( (Map)(resMap.get("data"))).get("profile_image") );

    }
}

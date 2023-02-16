package TurkishClass.Day_01;

import Day_03.BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C07_GetRequestWithExpectedData {
    @Test
    public void getRequestWithExpectedData(){

        String url="http://dummy.restapiexample.com/api/v1/employee/2";

        JSONObject innerobj=new JSONObject();
        innerobj.put("id",2);
        innerobj.put("employee_name","Garrett Winters");
        innerobj.put("employee_salary",170750);
        innerobj.put("employee_age",63);
        //innerobj.put("employee_image","null");

        JSONObject expctdBody=new JSONObject();

        expctdBody.put("status","success");
        expctdBody.put("message","Successfully! Record has been fetched.");
        expctdBody.put("data",innerobj);

        Response response=given().when().get(url);

        JsonPath jsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(jsonPath.get("status"),expctdBody.get("status"));
        softAssert.assertEquals(jsonPath.get("message"),expctdBody.get("message"));
        softAssert.assertEquals(jsonPath.get("data.id"),expctdBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(jsonPath.get("data.employee_name"),expctdBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(jsonPath.get("data.employee_salary"),expctdBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(jsonPath.get("data.employee_age"),expctdBody.getJSONObject("data").get("employee_age"));
       // softAssert.assertEquals(jsonPath.get("data.employee_image"),expctdBody.getJSONObject("data").get("employee_image"));


        softAssert.assertAll();
    }

}

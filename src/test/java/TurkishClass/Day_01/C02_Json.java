package TurkishClass.Day_01;

import org.json.JSONObject;
import org.junit.Test;

public class C02_Json extends TestBase{
    @Test
    public void json_Obj(){
        JSONObject firstObj=new JSONObject();
        firstObj.put("title","Ahmet");
        firstObj.put("body","Hello");
        firstObj.put("userId","1");
        System.out.println(firstObj);
    }
    @Test
    public void json_Obj2(){
        JSONObject innerObj=new JSONObject();
        innerObj.put("checkIn","2020-01-02");
        innerObj.put("checkOut","2020-02-19");

        JSONObject body=new JSONObject();
        body.put("firstname","jim");
        body.put("lastname","crown");
        body.put("additionally","breakfast");
        body.put("bookingdates",innerObj);
        body.put("price",1111);
        System.out.println(body);



    }
}

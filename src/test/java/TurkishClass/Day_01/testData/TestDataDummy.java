package TurkishClass.Day_01.testData;

import java.util.HashMap;

public class TestDataDummy {
    public int basariliststusCod=200;
    public String  contectType="application/json";
    public HashMap innerbodyMap(){
        HashMap<String,Object>innerbodyMap=new HashMap<>();
        innerbodyMap.put("id",3);
        innerbodyMap.put("employee_name","Ashton Cox");
        innerbodyMap.put("employee_salary",86000);
        innerbodyMap.put("employee_age",66);
        innerbodyMap.put("profile_image","");

        return innerbodyMap;
    }
    public HashMap expectedBodyMap(){
        HashMap<String,Object>expectedBodyMap=new HashMap<>();
        expectedBodyMap.put("status","success");
        expectedBodyMap.put("message","Successfully! Record has been fetched.");
        expectedBodyMap.put("data",innerbodyMap());

        return expectedBodyMap;
    }
}

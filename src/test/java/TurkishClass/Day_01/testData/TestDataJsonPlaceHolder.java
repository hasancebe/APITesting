package TurkishClass.Day_01.testData;

import org.json.JSONObject;

public class TestDataJsonPlaceHolder {
    public int basarilistatus=200;
    public  String basariliContectType="application/json; charset=utf-8";
    public  String connectionDegeri="keep-alive";
    public static JSONObject expectedBodyOlusturJSON(){
        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit" +
                " aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque" +
                " rem suscipit\nnam impedit esse");
        return expBody;
    }
    public static JSONObject requestBodyOlusturJSONAli(){
        JSONObject reqBodyAli=new JSONObject();
        reqBodyAli.put("userId","10");
        reqBodyAli.put("id",70);
        reqBodyAli.put("title","Ali");
        reqBodyAli.put("body","Merhaba");
        return reqBodyAli;
    }

}

package TurkishClass.Day_01.testData;

import java.util.HashMap;

public class TestDataHerokuapp {
    public HashMap bookingDateOlusturMap() {
         HashMap<String, Object>bookingdates=new HashMap<>();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");
        return bookingdates;

    }

    public HashMap bookingOlusturMap() {
        HashMap<String, Object>booking=new HashMap<>();
        booking.put("firstname","Ahmet");
        booking.put("lastname","Can");
        booking.put("totalprice",500.0);
        booking.put("deposipaid",false);
        booking.put("bookingdates",bookingDateOlusturMap());
        booking.put("additionalneeds","wi-fi");

        return booking;

    }
    public HashMap expbodyolusturMap() {
        HashMap<String, Object>expbodyMap=new HashMap<>();
        expbodyMap.put("bookingid","24");
        expbodyMap.put("booking",bookingOlusturMap());
        return expbodyMap;

    }
}
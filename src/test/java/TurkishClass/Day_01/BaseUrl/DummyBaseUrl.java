package TurkishClass.Day_01.BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {
    protected RequestSpecification specDummy;
    @Before
    public void setSpecDummyp(){
        specDummy=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1/").build();
    }
}

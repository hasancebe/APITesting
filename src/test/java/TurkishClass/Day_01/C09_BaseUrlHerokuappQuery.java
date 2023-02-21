package TurkishClass.Day_01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C09_BaseUrlHerokuappQuery extends BaseUrl.HerokuappBaseUrl {
    @Test
    public void get01(){
        specHerokuapp.pathParam("pp1","booking");
        Response response=given().
                            spec(specHerokuapp).
                            when().
                            get("/{pp1}");
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(5360));
    }

    @Test
    public void get02(){
        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Jim");
        Response response=given().spec(specHerokuapp).when().get("/{pp1}");
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(2));
    }
    @Test
    public void get03(){
        specHerokuapp.pathParam("pp1","booking").
                queryParams("firstname","Eric","lastname","Smith");

        Response response=given().spec(specHerokuapp).when().get("/{pp1}");
        //response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(1));

    }
}

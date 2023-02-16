package TurkishClass.Day_01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_BaseUrlJsonPlaceHolder extends  BaseUrl.JsonPlaceHolderBaseUrl{
    //1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET request
    // gonderdigimizde donen
    // response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin
    @Test
    public void  get01() {
        specJsonPlace.pathParam("pp1", "posts");
        Response response = given().spec(specJsonPlace).when().get("/{pp1}");
        response.then().assertThat().statusCode(200).body("title", Matchers.hasSize(100));
    }

    //2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        // bir GET request gonderdigimizde donen response’un status code’unun
        // 200 oldugunu ve “title” degerinin “optio dolor molestias sit”
        // oldugunu test edin

    @Test
    public void get02(){
        specJsonPlace.pathParams("pp1", "posts","pp2",44);
        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));


    }

    //3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
    // request gonderdigimizde donen response’un status code’unun
    // 200 oldugunu ve response body’sinin null oldugunu test edin
    @Test
    public void get03(){
        specJsonPlace.pathParams("pp1", "posts","pp2",50);
        Response response = given().spec(specJsonPlace).when().delete("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo(null));


    }
}

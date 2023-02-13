package Day_03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_GetRequest {
    /*
 http://dummy.restapiexample.com/api/v1/employees url
1) Let's print the names of all employees on the console
2) Let's print the name of the 3rd employee on the console
3) Let's print the names of the first 5 employees on the console
4) Let's print the last employee's name on the console
*/

    String url="http://dummy.restapiexample.com/api/v1/employees";

  //static  Response response;
    @Test
    public void getRequset(){
        Response response=given().when().get(url);
        JsonPath jsonPath=response.jsonPath();
       // 1) Let's print the names of all employees on the console

        System.out.println("all employee name "+ jsonPath.getString("data.employee_name") );

        //2) Let's print the name of the 3rd employee on the console
        System.out.println("3rd employee name "+ jsonPath.getString("data[3].employee_name"));

        //3) Let's print the names of the first 5 employees on the console
       System.out.println("first 5 employee name "+ jsonPath.get("data[5].employee_name"));

        //4) Let's print the last employee's name on the console
        System.out.println("last employee name "+ jsonPath.getString("data[-1].employee_name"));

    }
    //
}

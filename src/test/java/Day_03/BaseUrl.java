package Day_03;

public class BaseUrl {
    public static String bookingUserID(int id){

        return "https://restful-booker.herokuapp.com/booking/"+id+"" ;
    }

    public static String userIDHerokuapp(int id){

        return "https://reqres.in/api/users/"+id+"" ;
    }

    public static String userJsonPlaceHolderId(int id){
        return "https://jsonplaceholder.typicode.com/todos/"+id+"" ;
    }

    public static String employees(){
        return "http://dummy.restapiexample.com/api/v1/employees";
    }
}

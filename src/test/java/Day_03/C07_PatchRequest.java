package Day_03;

import org.junit.Test;
import utilities.ApiCalls;

public class C07_PatchRequest {
    //"https://jsonplaceholder.typicode.com/todos"
    //"title"=team104
@Test
    public  void patch01(){
    ApiCalls.patchRequestJsonPlaceHolder(2,200,1,"Team104",false);
}
}
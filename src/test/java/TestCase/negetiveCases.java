package TestCase;

import BaseTest.BaseTest;
import ReusableMethod.ReusedMethod;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import Utils.*;

import java.util.HashMap;

class negativeCases extends BaseTest {

    HashMap<String,String> Param;
    HashMap<String,String> Header;
    String Board_id,listId;

    @Test(priority=14)
    public void update_board() throws Exception {
        Param=ReusedMethod.getPutParams();
        Header=ReusedMethod.headerParam();
        Response res=httprequest.headers(Header).queryParams(Param)
                .when().put(endRequest.board()+Board_id)
                .then().assertThat().statusCode(400).extract().response();
        res.prettyPeek();
    }
    @Test(priority =15)
    public void updateCard() throws Exception {
        Param = ReusedMethod.getPutParams();
        Header = ReusedMethod.headerParam();
        Response res = httprequest.headers(Header).queryParams(Param).when().put( endRequest.lists() + listId).then()
                .assertThat().statusCode(400).extract().response();
        res.prettyPeek();
    }

}

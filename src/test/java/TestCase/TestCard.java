package TestCase;

import java.util.HashMap;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import ReusableMethod.ReusedMethod;
import Utils.endRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestCard extends BaseTest {
	
	HashMap<String,String> Param;
	HashMap<String,String> Header;
	
	String cardId;
	String labelId;
	
	@Test(priority = 5)
	public void create_card() throws Exception {
		System.out.println("in create card");
		
		Param=ReusedMethod.createCardParams();
		Header=ReusedMethod.headerParam();
		
		Response res=httprequest.headers(Header).queryParams(Param)
				.when().post(endRequest.card())
				.then().assertThat().statusCode(200).extract().response();
		res.prettyPeek();
		
		
		JsonPath js=ReusedMethod.rawToJson(res);
		cardId=(String)js.get("id");
		System.out.println("card id " +cardId);

		log.info("In Create Card Method");
		}
		
	@Test(priority=6)
	public void updateCard() throws Exception {
		System.out.println("in update method");
		
		Param=ReusedMethod.getPutParams();
		Header=ReusedMethod.headerParam();

		Response res=httprequest.headers(Header).queryParams(Param)
				.when().put(endRequest.card()+cardId)
				.then().assertThat().statusCode(200).extract().response();
		res.prettyPeek();
		log.info("In Update Card Method");
	}

	
	@Test(priority=7)
	public void getCard() throws Exception{
		
		System.out.println("in get method");
		
		Response res= httprequest.queryParam("key", ReusedMethod.key)
				.queryParam("token", ReusedMethod.token)
				.when().get(endRequest.card()+cardId);
		res.prettyPeek();
		log.info("In Get Card Method");
	}
	
	@Test(priority=8)
	public void deleteLabel() throws Exception{
		
		Header=ReusedMethod.headerParam();
		Param=ReusedMethod.removeLabelParams();
		
		Response res=httprequest.headers(Header).queryParams(Param)
				.when().delete(endRequest.card()+cardId+"/idLabels/"+labelId);
		res.prettyPeek();
		log.info("In Delete Lable Method");
	}
	
	@Test(priority=9)
	public void deleteCard() {
		Response res= httprequest.queryParam("key", ReusedMethod.key)
				.queryParam("token", ReusedMethod.token)
				.when().delete(endRequest.card()+cardId);
		res.prettyPeek();

		log.info("In Delete Card Method");
		
	}
}

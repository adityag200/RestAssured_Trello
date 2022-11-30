package TestCase;


import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import ReusableMethod.ReusedMethod;
import Utils.PropReader;
import Utils.*;
import Utils.endRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class TestBoard extends BaseTest {
	
	HashMap<String,String> Param;
	HashMap<String,String> Header;
	
	String Board_id;
	
	
	@Test(priority=1)
	public void create_board() throws Exception {
		System.out.println("in create method");
		
		Param=ReusedMethod.getParams();
		Header=ReusedMethod.headerParam();

		Response res=httprequest.headers(Header).queryParams(Param)
				.when().post(endRequest.board())
				.then().assertThat().statusCode(200).extract().response();
		res.prettyPeek();
		
		JsonPath js=ReusedMethod.rawToJson(res);
		Board_id=(String)js.get("id");
		System.out.println("Board id " +Board_id);
		
		log.info("In Create Boards Method");
		
	}
	@Test(priority=2)
	public void update_board(){
		System.out.println("in update method");
		
		Param=ReusedMethod.getPutParams();
		Header=ReusedMethod.headerParam();

		Response res=httprequest.headers(Header).queryParams(Param)
				.when().put(endRequest.board()+Board_id)
				.then().assertThat().statusCode(200).extract().response();
		res.prettyPeek();
		
		log.info("Updated Board");
		
	}
	
	@Test(priority=3)
	public void get_board(){
		
		System.out.println("in get method");
		
		Response res= httprequest.queryParam("key", ReusedMethod.key)
				.queryParam("token", ReusedMethod.token)
				.when().get(endRequest.board()+Board_id);
		res.prettyPeek();
		
		log.info("In Get Boards Method");
				
	}
	
	@Test(priority=4)
	public void delete_board(){
		
		System.out.println("in delete method");
		
		Response res= httprequest.queryParam("key", ReusedMethod.key)
				.queryParam("token", ReusedMethod.token)
				.when().delete(endRequest.board()+Board_id);
		res.prettyPeek();
		log.info("In Delete Boards Method");
	}

}

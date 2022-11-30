package TestCase;

import java.util.HashMap;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import ReusableMethod.ReusedMethod;
import Utils.endRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestList extends BaseTest {

	HashMap<String, String> Param;
	HashMap<String, String> Header;

	String listId;
	String a;

	@Test(priority = 10)
	public void create_list() throws Exception {

		Param = ReusedMethod.createListParams();
		Header = ReusedMethod.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when().post(endRequest.lists()).then()
				.assertThat().statusCode(200).extract().response();
		res.prettyPeek();

		JsonPath js = ReusedMethod.rawToJson(res);
		listId = (String) js.get("id");
		System.out.println("list id " + listId);
		log.info("In Create List Method");
	}

	@Test(priority = 11)
	public void updateList() throws Exception {
		System.out.println("in update method");

		Param = ReusedMethod.getPutParams();
		Header = ReusedMethod.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when().put(endRequest.lists() + listId).then()
				.assertThat().statusCode(200).extract().response();
		res.prettyPeek();
		log.info("In Update List Method");
	}

	@Test(priority = 12)
	public void getCard() throws Exception {

		System.out.println("in get method");

		Response res = httprequest.queryParam("key", ReusedMethod.key).queryParam("token", ReusedMethod.token)
				.when().get(endRequest.lists() + listId);
		res.prettyPeek();
		log.info("In Get Card Method");
	}

	@Test(priority = 13)
	public void archiveList() {

		Response res = httprequest.queryParam("key", ReusedMethod.key).queryParam("token", ReusedMethod.token).queryParam("closed", "true")
				.when().put(endRequest.lists() + listId);
		res.prettyPeek();
		log.info("In Archive List Method");

	}

}

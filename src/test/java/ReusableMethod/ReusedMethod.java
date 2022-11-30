package ReusableMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import Utils.PropReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusedMethod {
	static PropReader ob = new PropReader();
	public static HashMap<String, String> params = new HashMap();
	public static HashMap<String, String> headers = new HashMap();
	
	

	public static String key = ob.getProperty("Api_key");
	public static String token = ob.getProperty("token");
	public static String name = ob.getProperty("name");
	public static String New_name = ob.getProperty("Updated_Name");
	public static String color = ob.getProperty("color");
	public static String idList = ob.getProperty("idList");
	public static String cardName = ob.getProperty("cardName");
	public static String idBoard = ob.getProperty("idBoard");

	public static JsonPath rawToJson(Response res) {
		String response = (res).asString();
		JsonPath x = new JsonPath(response);
		return x;
	}

	public static HashMap<String, String> headerParam() {

		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");

		return headers;
	}

	public static HashMap<String, String> getParams() {

		params.put("key", key);
		params.put("token", token);
		params.put("name", name);

		return params;
	}

	public static HashMap<String, String> getPutParams() {

		params.put("key", key);
		params.put("token", token);
		params.put("name", New_name);

		return params;
	}

	public static HashMap<String, String> createCardParams() {

		params.put("idList", idList);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> getCreateLabelParams() {

		params.put("name", cardName);
		params.put("color", color);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> removeLabelParams() {

		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> createListParams() {

		params.put("name", name);
		params.put("idBoard", idBoard);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> archiveListParam() {

		params.put("closed", "true");
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	
}

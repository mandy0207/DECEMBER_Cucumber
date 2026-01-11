package utils;

import io.restassured.path.json.JsonPath;

public class JSONParser {

	
	public static JsonPath getJsonParser(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
}

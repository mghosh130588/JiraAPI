package serenity.JiraAPI.testbase;

import io.restassured.path.json.JsonPath;

public class Utility {

	
	public  String jsonpathparse(String res, String key) {
		JsonPath js = new JsonPath(res);
		String value = js.getString(key);
		return value;
		
	}
}

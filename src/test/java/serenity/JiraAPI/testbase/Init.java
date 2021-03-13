package serenity.JiraAPI.testbase;

import static io.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import net.serenitybdd.rest.SerenityRest;

public class Init {
	
	public static SessionFilter sessionfilter = new SessionFilter();
	
	@BeforeClass
	public static void createsession() {
		RestAssured.baseURI = "http://localhost:8080";
		SerenityRest.given().log().all()
		.header("Content-Type","application/json")
		.body("{ \"username\": \"mousumighosh\", \"password\": \"Rai2017!\" }")
		.filter(sessionfilter)
		.when().post("/rest/auth/1/session")
		.then().log().all().assertThat()
		.statusCode(200);

}


	
		


}

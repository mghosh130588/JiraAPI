package serenity.JiraAPI.testbase;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReusuableSpecification {
	
	public static RequestSpecification requestspecification;

	
	public static RequestSpecification getRequestSpec() {
		
		//ReusuableSpecification.createsession();
		RequestSpecBuilder rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON)
		.addHeader("Content-Type","application/json")
		.addFilter(Init.sessionfilter);
		requestspecification = rspec.build();	
		return requestspecification;
	}
}

package serenity.JiraAPI.cucumber.steps;

import static io.restassured.RestAssured.given;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import serenity.JiraAPI.pojo.CreateIssueBody;
import serenity.JiraAPI.testbase.Init;
import serenity.JiraAPI.testbase.JiraAPIResources;
import serenity.JiraAPI.testbase.ReusuableSpecification;
import serenity.JiraAPI.testbase.Utility;

import static org.junit.Assert.*;

public class StepDefinitions extends Utility{
	
	static RequestSpecification req;
	static Response res;
	public static String Issuekey;
	public static String description;
	
	@Given("^Create Issue API payload is present for a project (.*) for a particular Session and description (.*)$")
	public void create_Issue_API_payload_is_present_for_a_for_a_particular_Session_and(String Projkey, String summary) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//RequestSpecification rs;
		//rs = ReusuableSpecification.getRequestSpec();
		description = "This is from final test serenity";
		req = SerenityRest.given().spec(ReusuableSpecification.getRequestSpec()).log().all()
		.body(CreateIssueBody.createIssuebody(Projkey, summary,description));
	}


	
	/*@When("^user send a \"([^\"]*)\" request to create Issue$")
	public void user_send_a_request_to_create_Issue(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    res = req.when().post("/rest/api/2/issue")
	    		.then().log().all()
	    		.extract().response();
	    Issuekey = jsonpathparse(res.asString(),"key");
	}

	@Then("^validate that API call is success with status code (\\d+)$")
	public void validate_that_API_call_is_success_with_status_code(int statuscode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(res.getStatusCode(),statuscode);
		
	   
	}
	*/
	
	@Then("^API call is success with statuscode (.*)$")
	public void api_call_is_success_with_statuscode(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(res.getStatusCode(),arg1);
	}

	
	
	@Then("^validate that IssueId is present when \"([^\"]*)\" request \"([^\"]*)\" API is called using the \"([^\"]*)\"$")
	public void validate_that_IssueId_is_present_when_request_API_is_called_using_the(String method, String resource, String id) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		req = SerenityRest.given().spec(ReusuableSpecification.getRequestSpec()).log().all();
		user_send_a_request_to(method,resource);
		if(res.getStatusCode()==404) {
			System.out.println("The issue is not present");
		}
		else {
		assertEquals(res.getStatusCode(),200);
		assertEquals(jsonpathparse(res.asString(),"fields.description"), description);
		}
		
	}

	@Given("^Delete Issue API payload is present for a issue$")
	public void delete_Issue_API_payload_is_present_for_a_issue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		req = SerenityRest.given().spec(ReusuableSpecification.getRequestSpec()).log().all().pathParam("key",Issuekey);
			
		
	}
	
	//@When("^user send a \"([^\"]*)\" request to delete Issue$")
	/*
	public void user_send_a_request_to_delete_Issue(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    res = req.when().delete("/rest/api/2/issue/{key}")
	    		.then().log().all().extract().response();
	}
	*/
	
	

@When("^user send a \"([^\"]*)\" request to \"([^\"]*)\"$")
public void user_send_a_request_to(String method, String resource) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	JiraAPIResources jiraapi = JiraAPIResources.valueOf(resource);
	if(method.equalsIgnoreCase("POST")) {
		res = req.when().post(jiraapi.getResource())
	    		.then().log().all()
	    		.extract().response();
		
		 Issuekey = jsonpathparse(res.asString(),"key");
		
	}
	else if(method.equalsIgnoreCase("DELETE"))
	{
		res = req.when().delete(jiraapi.getResource())
	    		.then().log().all().extract().response();
		
	}
	else 
	{
		res = req.pathParam("key", Issuekey).when().get(jiraapi.getResource())
				.then()
				.log().all()
				.extract().response();
		
	}
}
	
}

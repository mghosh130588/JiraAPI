package serenity.JiraAPI.cucumber.steps;

import java.io.IOException;



public class Hooks {
	

	@cucumber.api.java.Before("@DeleteIssue")
	public void beforedeletescenario() throws Throwable {
	
		StepDefinitions sd = new StepDefinitions();
		if (StepDefinitions.Issuekey == null) {
			sd.create_Issue_API_payload_is_present_for_a_for_a_particular_Session_and("RES", "Detelescenario tag");
		sd.user_send_a_request_to("POST", "createIssue");
		StepDefinitions.Issuekey = sd.jsonpathparse(sd.res.asString(), "key");
		}
		

}
}
	

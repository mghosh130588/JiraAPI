package serenity.JiraAPI.pojo;

public class CreateIssueBody {
	
	
	public static String createIssuebody(String projectkey, String Summary, String Decription) {
		
		String body = "{\n" + 
				"  \"fields\": {\n" + 
				"    \"summary\": \"" + Summary + "\",\n" + 
				"    \"issuetype\": {\n" + 
				"      \"name\": \"Bug\"\n" + 
				"    },\n" + 
				"    \"project\": {\n" + 
				"      \"key\": \"" + projectkey +"\"\n" + 
				"    },\n" + 
				"    \"description\": \"" + Decription + "\",\n" + 
				"    \"reporter\": {\n" + 
				"     \"name\": \"mousumighosh\",\n" + 
				"     \"emailAddress\": \"mousumi.nit@gmail.com\"\n" + 
				"    }\n" + 
				"}\n" + 
				"}";
		
		return body;
		
		
	}

}

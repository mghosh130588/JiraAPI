package serenity.JiraAPI.testbase;

public enum JiraAPIResources {
	

	createIssue("/rest/api/2/issue"),
	getIssue("/rest/api/2/issue/{key}"),
	deleteIssue("/rest/api/2/issue/{key}");
	
	private String resource;
	JiraAPIResources(String resource){
		this.resource = resource;
		
	}
	
	public String getResource() {
		return resource;
		
		
	}

}

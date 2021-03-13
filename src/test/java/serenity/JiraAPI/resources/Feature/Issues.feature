Feature: To verify the functionality for Issues Create  and  get and detele functionality for Issues in JiraAPI

@CreateIssue
@Positive
Scenario Outline: Verify that the Create Issue API is working correctly
	Given Create Issue API payload is present for a project <Project> for a particular Session and description <description>
	When user send a "POST" request to "createIssue"
	Then API call is success with statuscode 201
	And validate that IssueId is present when "GET" request "getIssue" API is called using the "IssueID"

		Examples:
		| Project | description|
		|RES | this is the test res summary |
		
@DeleteIssue
@Positive
Scenario: Verify the Delete Issue API is working correctly
	Given Delete Issue API payload is present for a issue
	When user send a "DELETE" request to "deleteIssue"
	Then API call is success with statuscode 204
	And validate that IssueId is present when "GET" request "getIssue" API is called using the "IssueID"

@CreateIssue
@Negative
Scenario Outline: Verify that 400 error is displayed when Create issue API is called with invalid project name
	Given Create Issue API payload is present for a project <Project> for a particular Session and description <description>
	When user send a "POST" request to "createIssue"
	Then API call is success with statuscode 400

		Examples:
		| Project | description|
		|RES5 | this is the invalid projectid |
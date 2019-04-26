Feature: UserLogin 
	Description: User login in the factset application
  
@smoke
Scenario Outline: Validating the error message when there is no email and password 
	Given Factset application is launched 
	When user navigates to Login 
	And user clicks login button 
	Then user validates the error <message> 
	
Examples:
|message|
|You must enter your factset.net ID to login.|

@smoke
Scenario Outline: Validating the error message when there is invalid email and invalid password 
	Given Factset application is launched 
	When user navigates to Login 
	And user enters email <email1> and password <password1>
	And user clicks login button 
	Then user validates the error <message>
	
Examples:
|email1|password1|message|
|hari  |pass  |Invalid username or pasword.|

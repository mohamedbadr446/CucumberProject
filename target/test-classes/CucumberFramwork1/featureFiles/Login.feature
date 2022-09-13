Feature: Login into account
	Existing stackoverflow user should be able to login into account correct credentials 

Scenario: Login into account with correct details
	Given User navigates to stackoverflow website
	And User clicks on the login button on homepage
	And User enters avalide username
	And User enters avalide password
	When User clicks on the login button   
	Then User should be taken to the successful login page
	
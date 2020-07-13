Feature: Free CRM Login feature

Scenario: Free CRM Login test Scenaio
	Given User is already on login page
	When Title of login page is Free CRM
	Then User enters username and password
	Then User is on Home Page
	Then Close the browser
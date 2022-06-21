
@SimpleLogin
Feature: Vcentry Login feature Application
@VcentryLogin @Vcentry
Scenario:Validate Vcentry Login page

Given User is on the Homepage
When User enters the Username
And User enters the Password
Then User should logged in Successfully
@NopLogin
Scenario:Validate Nop Login page

Given User is Navigate to the Homepage
When User enter the Username as "admin@yourstore.com"
And User enter the Password as "admin"
Then User loggedin Successfully






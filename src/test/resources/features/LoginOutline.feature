
Feature: Vcentry Login feature Application

@NopLoginOuline
Scenario Outline:Validate Nop Login
Given User navigate the Homepage
When User enter the username as <username> and password as <password>
And User Logged In Successfully

Examples:
|username|password|
|admin@yourstore.com|admin|
|admin@yourstore.com|u&d@72363|








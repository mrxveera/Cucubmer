 Feature: To validate the login in functionlity of arogs application
 
 
 Scenario Outline: To validate the login functionality with invalid credentials
 Given The user should be in argos page
 When  The user enter the correct  "<mail name>"   and invalid "<password>"  
 And  The uaer has to click the sign in securely button
 Then The user should navigate to the invalid page
 
 
 Examples:
   |mail name||password|
   |hakunama@gmail.com||2638494@hdajd|
   |hahhhva@gmail.com||263asfr4@hdajd|
   |hawin@gmail.com||2638494@hdood|
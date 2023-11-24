Feature:
Login_funcationality

Scenario:
user entered valided creditional check wheather user able to see the welcome page

Given when user entered the valid email id and click on next button
And enter the valid password and click on Sign in button
Then check wheather the user is able to see the Welcome page 

Scenario:
user entered invalided creditional check wheather user able to see the welcome page

Given when user entered the valid email id and click on next button
And enter the invalid password and click on Sign in button
Then check wheather the user able to login to welcome page
 



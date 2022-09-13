$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login into account",
  "description": "Existing stackoverflow user should be able to login into account correct credentials",
  "id": "login-into-account",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5199000536,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login into account with correct details",
  "description": "",
  "id": "login-into-account;login-into-account-with-correct-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User navigates to stackoverflow website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User clicks on the login button on homepage",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User enters avalide username",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User enters avalide password",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User clicks on the login button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User should be taken to the successful login page",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.user_navigates_to_stackoverflow_website()"
});
formatter.result({
  "duration": 1610763021,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_clicks_on_the_login_button_on_homepage()"
});
formatter.result({
  "duration": 2525153561,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_enters_avalide_username()"
});
formatter.result({
  "duration": 6977571266,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_enters_avalide_password()"
});
formatter.result({
  "duration": 2129817017,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_clicks_on_the_login_button()"
});
formatter.result({
  "duration": 2051671094,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_should_be_taken_to_the_successful_login_page()"
});
formatter.result({
  "duration": 3139570824,
  "status": "passed"
});
formatter.after({
  "duration": 5278434186,
  "status": "passed"
});
});
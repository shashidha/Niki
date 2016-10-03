$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/1/chat.feature");
formatter.feature({
  "line": 3,
  "name": "Chat feature",
  "description": "",
  "id": "chat-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@baseChatScenarios"
    }
  ]
});
formatter.before({
  "duration": 8151934333,
  "status": "passed"
});
formatter.before({
  "duration": 544973,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "user must be able to chat",
  "description": "",
  "id": "chat-feature;user-must-be-able-to-chat",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@baseSendChat"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I enter the username to start chat",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I click on the added user",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I navigate to chat window of the user and send chat",
  "keyword": "And "
});
formatter.match({
  "location": "ChatSteps.I_enter_the_username_to_start_chat()"
});
formatter.result({
  "duration": 16988019868,
  "status": "passed"
});
formatter.match({
  "location": "ChatSteps.I_click_on_the_added_user()"
});

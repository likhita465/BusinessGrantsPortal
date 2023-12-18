Feature: Login functionality for Business Grants Portal

    Scenario: Login into the Business Grants Portal
      Given user is on the Login Page
      When user entered the username and password
      And user click on the SignIn button
      Then verify 'Business Grants Portal' title is displayed
      And verify Login Button is displayed
      When user click on login button
      Then verify 'CorpPass Login' title is displayed
      When user entered all the required details
      And user click on the login button
      Then verify 'My Grants' header is displayed

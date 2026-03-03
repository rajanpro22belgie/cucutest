Feature: Login

Scenario: Valid login
  Given user is on login page
  When user enters username "student" and password "Password123"
  And user clicks login
  Then user should be logged in

Scenario: Invalid login
  Given user is on login page
  When user enters username "wronguser" and password "wrongpass"
  And user clicks login
  Then user should see an error message

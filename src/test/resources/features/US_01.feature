Feature: User Login Validation


  @ac1 @ui
  Scenario: Display error messages when sign in button is clicked without entering email and password
    Given the user is on the login page
    When the user clicks the sign in button
    Then the error message "This is a required field." should appear for both email and password fields

  @ac2 @ui
  Scenario: user enters invalid email format and password
    Given the user is on the login page
    When the user enters invalid format email and password
      | username | someonegmailcom |
      | password | admin           |
    And the user clicks the sign in button
    Then Message "Please enter a valid email address (Ex: johndoe@domain.com)." should appear.


  @ac3 @ui
  Scenario: user enters invalid email and password
    Given the user is on the login page
    When the user enters invalid format email and password
      | username | someone@gmail.com |
      | password | admin             |
    And the user clicks the sign in button
    Then Message error "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later." should appear on the page.







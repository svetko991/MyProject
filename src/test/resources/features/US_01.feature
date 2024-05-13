Feature: User Login Validation

   As a user I should not be able to login.


  Background:
    Given the user is on the login page

  @ac1 @ui
  Scenario: Display error messages when sign in button is clicked without entering email and password
    When the user clicks the sign in button
    Then the error message "This is a required field." should appear for both email and password fields

  @ac2 @ui
  Scenario: user enters invalid email format and password
    When the user enters invalid email and password
      | username | someonegmailcom |
      | password | admin           |
    And the user clicks the sign in button
    Then Message "Please enter a valid email address (Ex: johndoe@domain.com)." should appear.


  @ac3 @ui
  Scenario: user enters invalid email and password
    When the user enters invalid email and password
      | username | someone@gmail.com |
      | password | admin             |
    And the user clicks the sign in button
    Then message error "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.ab" should appear on the page.







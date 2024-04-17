package com.projectName.step_definitions;


import com.projectName.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.Map;


public class Norfield_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        loginPage.login.click();
    }

    @When("the user clicks the sign in button")
    public void the_user_clicks_the_sign_in_button() {

        loginPage.signInBtn.click();
    }

    @Then("the error message {string} should appear for both email and password fields")
    public void the_error_message_should_appear_for_both_email_and_password_fields(String expectedErrorMsg) {

        String actualEmailErrMsg = loginPage.emailErrorMsg.getText();
        String actualPasswordErrMsg = loginPage.passwordErrorMsg.getText();

        Assert.assertEquals("The email and password messages does not match", expectedErrorMsg, actualEmailErrMsg);
        Assert.assertEquals(expectedErrorMsg, actualPasswordErrMsg);

    }

    @When("the user enters invalid format email and password")
    public void theUserEntersInvalidFormatEmailAndPassword(Map<String, String> credentials) {

        loginPage.emailField.sendKeys(credentials.get("username"));
        loginPage.passwordField.sendKeys(credentials.get("password"));

    }

    @Then("Message {string} should appear.")
    public void message_should_appear(String expectedMessage) {

        String actualMessage = loginPage.emailErrorMsg.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Then("Message error {string} should appear on the page.")
    public void messageErrorShouldAppearOnThePage(String expectedMessage) {

        String actualMessage = loginPage.messageError.getText();

        Assert.assertEquals(expectedMessage, actualMessage);


    }
}

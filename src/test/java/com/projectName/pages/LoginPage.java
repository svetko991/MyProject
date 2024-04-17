package com.projectName.pages;

import com.projectName.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Pageable;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@title='Email']")
    public  WebElement emailField;

    @FindBy(xpath = "//input[@title='Password']")
    public  WebElement passwordField;

    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signInBtn;

    @FindBy(id = "email-error")
    public WebElement emailErrorMsg;

    @FindBy(id = "pass-error")
    public WebElement passwordErrorMsg;

    @FindBy(css = ".message-error.error.message")
    public WebElement messageError;



}

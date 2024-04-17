package com.projectName.pages;

import com.projectName.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    @FindBy(css = ".login-link")
    public WebElement login;

    @FindBy(linkText = "My Account")
    public WebElement myAccount;

    @FindBy(css = ".action.showcart")
    public WebElement myCArt;

    @FindBy(linkText = "Checkout")
    public WebElement checkout;


}

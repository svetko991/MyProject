package com.projectName.pages;

import com.projectName.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
package com.projectName.pages;

import com.projectName.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Pageable;

public class Login {

    private Login() {
        PageFactory.initElements(Driver.getDriver(),this);
    }




}

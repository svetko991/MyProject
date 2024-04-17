package com.projectName.pages;

import com.projectName.utilities.Driver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {


    private BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }


}

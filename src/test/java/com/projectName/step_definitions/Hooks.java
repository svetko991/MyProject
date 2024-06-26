package com.projectName.step_definitions;

import com.projectName.utilities.ConfigurationReader;
import com.projectName.utilities.DB_Util;
import com.projectName.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before("@ui")
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
    }


    @After("@ui")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpDB() {

        System.out.println("Connecting to database");
        DB_Util.createConnection();

    }

    @After("@db")
    public void tearDownDB() {

        System.out.println("closing database connection");
        DB_Util.destroy();
    }


}

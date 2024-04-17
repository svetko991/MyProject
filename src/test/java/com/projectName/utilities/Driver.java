package com.projectName.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    //SINGLETON DESIGN PATTERN //
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            String browserType = "";
            if (System.getProperty("BROWSER") == null) {
                browserType = ConfigurationReader.getProperty("browser");
            } else {
                browserType = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browserType);

            switch (browserType) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "headless-chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "52.201.221.183";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--start-maximized");
                        driverPool.set(new RemoteWebDriver(url, chromeOptions));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        return driverPool.get();
    }


    public static void closeDriver() {

        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}

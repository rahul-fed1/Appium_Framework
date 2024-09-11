package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {
    static AppiumDriver driver;

    public static void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
        capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
        capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
//        capabilities.setCapability("app", "C:\\Users\\280707\\Downloads\\clickup.apk");
//        capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));
//        capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
        capabilities.setCapability("enforceXPath1", true);
        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}

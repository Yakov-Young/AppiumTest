package ru.kemsu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class ConfigTest {


    protected AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:deviceName", "Galaxy Tab A");
        capabilities.setCapability("appium:platformVersion", "7.1.1");
        capabilities.setCapability("appium:appPackage", "org.wikipedia");
        capabilities.setCapability("appium:appActivity", ".main.MainActivity");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("app",
                "C:\\Users\\Sibiryakov\\IdeaProjects\\wikiAppium\\apks\\org.wikipedia-50479.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void firstTest() {
        System.out.println("run testing");
        ToolForTesting tool = new ToolForTesting(driver);
    }
}
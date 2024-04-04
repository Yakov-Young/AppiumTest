package ru.kemsu.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {

    public MainPageObject(AppiumDriver<WebElement> driver) {
        this.DRIVER = driver;
    }

    private final AppiumDriver<WebElement> DRIVER;

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSecond) {
        WebDriverWait driverWait = new WebDriverWait(DRIVER, timeoutInSecond);
        driverWait.withMessage(error_message + '\n');
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementAndClick(By by, String error_message, long timeoutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSecond);
        element.click();
    }

    public void waitForElementAndSendKey(By by, String keys, String error_message, long timeoutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSecond);
        element.sendKeys(keys);
    }
}


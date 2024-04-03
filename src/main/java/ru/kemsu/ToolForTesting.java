package ru.kemsu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolForTesting {

    public ToolForTesting(AppiumDriver driver) {
        this.DRIVER = driver;
    }

    private final AppiumDriver DRIVER;

    protected WebElement waitForElementPresent(By by, String error_message, long timeoutInSecond) {
        WebDriverWait driverWait = new WebDriverWait(DRIVER, timeoutInSecond);
        driverWait.withMessage(error_message + '\n');
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement waitForElementAndClick(By by, String error_message, long timeoutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSecond);
        element.click();
        return element;
    }

    protected WebElement waitForElementAndSendKey(By by, String keys, String error_message, long timeoutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSecond);
        element.sendKeys(keys);
        return element;
    }
}


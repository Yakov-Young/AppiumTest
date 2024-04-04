package ru.kemsu.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject{
    private static final String
    SEARCH_PASS_ELEMENT = "//*[contains(@text, 'Пропустить')]",
    SEARCH_INPUT_ELEMENT = "//*[contains(@text, 'Поиск по Википедии')]",
    SEARCH_ELEMENT = "",
    SEARCH_RESULT = "//*[contains(@resource-id, 'org.wikipedia:id/page_list_item_description')" +
            " and contains(@text, '{SUBSTRING}')]";

    public SearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void passFirstPage() {
        this.waitForElementAndClick(By.xpath(SEARCH_PASS_ELEMENT),
                "Не возможно нажать на кнопку 'Пропустить'", 2);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INPUT_ELEMENT),
                "Не возможно нажать на поле ввода", 2);
    }

    public void typeSearchLine(String searchLine) {
        this.waitForElementAndSendKey(By.xpath(SEARCH_INPUT_ELEMENT), searchLine,
                "Не возможно нажать на поле ввода", 2);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),
                "Невозможно найти поле " + substring, 5);
    }

    private String getResultSearchElement(String substring) {
        return SEARCH_RESULT.replace("{SUBSTRING}", substring);
    }
}

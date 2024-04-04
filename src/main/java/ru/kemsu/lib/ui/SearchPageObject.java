package ru.kemsu.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject{
    private static final String
    SEARCH_PASS_ELEMENT = "//*[contains(@text, 'Пропустить')]",
    SEARCH_INPUT_ELEMENT = "//*[contains(@text, 'Поиск по Википедии')]",
    SEARCH_ADD_READING_LIST_INPUT = "//android.widget.EditText[@resource-id='org.wikipedia:id/text_input']",
    SEARCH_XPATH = "//*[contains(@text, '{SUBSTRING}')]",
    SEARCH_RESULT = "//*[contains(@resource-id, 'org.wikipedia:id/page_list_item_description')" +
            " and contains(@text, '{SUBSTRING}')]",
    SEARCH_TITLE_ELEMENT = "//android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='{SUBSTRING}']",
    SEARCH_FAVORITE_ELEMENT = "//android.widget.TextView[@content-desc='Сохранить']",
    SEARCH_ADD_READING_LIST_ELEMENT = "//android.widget.Button[@resource-id='org.wikipedia:id/snackbar_action']",
    SEARCH_ACTION_ELEMENT = "//android.widget.ImageView[@content-desc=\"Ещё\"]";

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
        String search_result_xpath = getResultSearch(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),
                "Невозможно найти поле " + substring, 5);
    }

    private String getResultSearch(String substring) {
        return SEARCH_RESULT.replace("{SUBSTRING}", substring);
    }

    public void waitForClickByText(String text) {
        String search_result_xpath = getXpathSearchElement(text);
        this.waitForElementAndClick(By.xpath(search_result_xpath),
                "Элемент " + text + " ненайден", 5);
    }

    private String getXpathSearchElement(String substring) {
        return SEARCH_XPATH.replace("{SUBSTRING}", substring);
    }

    public void clickOnFavoriteElement() {
        this.waitForElementAndClick(By.xpath(SEARCH_FAVORITE_ELEMENT),
                "Невозможно добавить в избранное", 5);
    }

    public void clickOnAddReadingList() {
        this.waitForElementAndClick(By.xpath(SEARCH_ADD_READING_LIST_ELEMENT),
                "Невозможно добавить в список для чтения", 5);
    }

    public void initAddReadingListInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_ADD_READING_LIST_INPUT),
                "Не возможно нажать на поле ввода", 2);
    }

    public void typeAddReadingListLine(String searchLine) {
        this.waitForElementAndSendKey(By.xpath(SEARCH_ADD_READING_LIST_INPUT), searchLine,
                "Не возможно нажать на поле ввода", 2);
    }

    public void clickOnActionElement() {
        this.waitForElementAndClick(By.xpath(SEARCH_ACTION_ELEMENT),
                "Невозможно добавить в список для чтения", 5);
    }
}

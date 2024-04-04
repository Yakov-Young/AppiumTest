package ru.kemsu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.kemsu.lib.ConfigTest;
import ru.kemsu.lib.ui.MainPageObject;
import ru.kemsu.lib.ui.SearchPageObject;

import java.beans.Transient;

public class WikiTest extends ConfigTest {

    private MainPageObject tool;

    @Test
    public void testFirstTest() {
        super.firstTest();

        MainPageObject tool = new MainPageObject(super.driver);

        tool.waitForElementAndClick(By.xpath("//*[contains(@text, 'Пропустить')]"),
                "Не возможно нажать на кнопку 'Пропустить'", 2);

        tool.waitForElementAndClick(By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
                "Не возможно нажать на поле ввода", 2);

        tool.waitForElementAndSendKey(By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
                "Кемеровский государственный университет",
                "Поле ввода не обнаружено", 5);

        tool.waitForElementAndClick(By.xpath("//*[contains(@resource-id, 'org.wikipedia:id/page_list_item_description')" +
                        " and contains(@text, 'высшее учебное заведение в Кемерове')]"),
                "Невозможно найти 'КемГУ'", 5);

        String title_element = tool.waitForElementPresent(By.xpath("//android.widget.TextView[@text=\"Кемеровский государственный университет\"]"),
                "Не обнаружен искомый текст", 5).getText();
        Assert.assertEquals("Несовпадение в названии статьи",
                "Кемеровский государственный университет", title_element);
    }

    @Test
    public void testSearchElement() {
        SearchPageObject pageObject = new SearchPageObject(driver);

        pageObject.passFirstPage();
        pageObject.initSearchInput();
        pageObject.typeSearchLine("Кемеровский государственный университет");
        pageObject.waitForSearchResult("высшее учебное заведение в Кемерове");
    }
}
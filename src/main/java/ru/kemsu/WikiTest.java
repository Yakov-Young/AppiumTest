package ru.kemsu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WikiTest extends ConfigTest {

    @Override
    public void firstTest() {
        super.firstTest();

        ToolForTesting tool = new ToolForTesting(super.driver);

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

        WebElement title_element = tool.waitForElementPresent(By.xpath("//android.widget.TextView[@text=\"Кемеровский государственный университет\"]"),
                "Не обнаружен искомый текст", 5);
        Assert.assertEquals("Несовпадение в названии статьи",
                "Кемеровский государственный университет", title_element.getText());

    }
}

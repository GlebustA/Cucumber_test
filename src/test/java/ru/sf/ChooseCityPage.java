package ru.sf;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ChooseCityPage {

    private static final String SEARCH_FIELD_CLASS = "form-control";
    private static final String ERROR_MESSAGE_SPAN_CLASS  = "city-not-found";

    private final WebDriver webDriver;

    public ChooseCityPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void go(String url) {
    webDriver.get(url);
    }
    public void searchCity(String city) {
        webDriver.findElement(By.className("w-choose-city-widget-label")).click(); //кликаем на выбор города
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15)); // добавляю переменную ожидания
        wait.until(ExpectedConditions.elementToBeClickable(By.className(SEARCH_FIELD_CLASS))).sendKeys(city, Keys.ENTER); // после того как кнопка поискака появляется отправляю туда название города и выбираю его
    }
    public String getCityNotFoundMessage() {
        return webDriver.findElement(By.className(ERROR_MESSAGE_SPAN_CLASS)).getText();

    }

}

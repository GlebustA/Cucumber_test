package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CityMenuPage {
    private final WebDriver webDriver;
    private final static String ACTIVE_CITY_SPAN_XPATH = "//div[@class='city-select w-choose-city-widget']//p";

    public CityMenuPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getCurrentActiveCity() {
        webDriver.navigate().refresh();
        return webDriver.findElement(By.xpath(ACTIVE_CITY_SPAN_XPATH)).getText();

    }
}

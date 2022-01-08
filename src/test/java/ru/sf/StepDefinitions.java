package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final ChooseCityPage chooseCityPage;
    public static final CityMenuPage cityMenuPage;

     static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Glebusterenko\\IdeaProjects\\cc\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        chooseCityPage = new ChooseCityPage(webDriver);
        cityMenuPage = new CityMenuPage(webDriver);
    }

    @Given("url of dns shop {string}")
    public void url_of_dns_shop(String url) {
         chooseCityPage.go(url);
    }


    @Then("choose city {string}")
    public void choose_city(String city) {
         chooseCityPage.searchCity(city);
    }
    @Then("assert that chosen city is {string}")
    public void assert_that_chosen_city_is(String expectedCity) {
        final var CurrentActiveCity = cityMenuPage.getCurrentActiveCity();
       assertEquals(expectedCity, CurrentActiveCity);
    }
    @Then("assert that user get message {string}")
    public void assert_that_user_get_message(String errorMessage) {
       final var CityNotFoundMessage = chooseCityPage.getCityNotFoundMessage();
        assertEquals(errorMessage, CityNotFoundMessage);
    }

}

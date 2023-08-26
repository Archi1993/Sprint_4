package praktikum;


import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import praktikum.pages.MainPage;

import java.io.File;
import java.time.Duration;


public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() {
        //Запуск тестов через Chrome Browser
        this.driver = new ChromeDriver();

        //Запуск тестов через Firefox Browser
        //this.driver = new FirefoxDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookiesButton();

    }


    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }


}

package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    // Поле driver
    private WebDriver driver;

    // Локатор аккордиона с вопросами и ответами
    private String accordion = ".//div[@id='accordion__heading-";

    //Локатор поля аккордеона с ответом
    private By answerAccordionText = By.xpath(".//div[@aria-expanded='true']/parent :: div/parent::div/div[@class='accordion__panel']/p");

    //Локатор верхней кнопки "Заказать"
    private By orderTopButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Локатор нижней кнопки "Заказать"
    private By orderBottomButton = By.xpath(".//button/parent::div[@class='Home_FinishButton__1_cWm']");

    // Кнопка принятия использования Сookies
    private By acceptCookiesButton = By.xpath(".//button[@id='rcc-confirm-button']");

    // Локатор до лейбла "Вопросы о важном"
    public By mainQuestionLabel = By.xpath(".//div[5]/div[1]");

    // Конструктор класса page object
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //  Кликнуть по верхней кнопке "Заказать"
    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    //  Кликнуть по нижней кнопке "Заказать"
    public void clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
    }

    //  Кликнуть по кнопке принятия использования Сookies
    public void clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
    }

    //Скролл до текста "Вопросы о важном"
    public void scrollToMainQuestionLabel(WebDriver driver) {
        WebElement element = driver.findElement(mainQuestionLabel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Передаём xpath акордеона
    public String getAccordionLocator() {
        return accordion;
    }

    //Метод получения текста ответа
    public String getAnswerAccordionText() {
        String textElement = driver.findElement(answerAccordionText).getText();
        return textElement;
    }
}
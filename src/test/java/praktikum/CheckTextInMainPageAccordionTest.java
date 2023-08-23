package praktikum;


import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;

import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(Parameterized.class)
public class CheckTextInMainPageAccordionTest {
    private final String result;
    private final int accordionLocator;


    public CheckTextInMainPageAccordionTest(String result, int accordionLocator) {
        this.result = result;
        this.accordionLocator = accordionLocator;
    }

    @Parameterized.Parameters(name = "Проверка текста в аккордеоне. Проверка страницы: {1}")
    public static Object[] data() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    public void checkTextInAccordion() {

        WebDriver driver = driverRule.getDriver();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.scrollToMainQuestionLabel(driver);
        objMainPage.buildLocatorAndClick(accordionLocator);
        //driver.findElement(By.xpath(String.format("%s%d']", objMainPage.getAccordionLocator(), accordionLocator))).click();
        String answerText = objMainPage.getAnswerAccordionText();
        MatcherAssert.assertThat(result, equalTo(answerText));
    }
}






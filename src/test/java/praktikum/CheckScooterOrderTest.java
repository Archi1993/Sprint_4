package praktikum;

import org.junit.Rule;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;
import praktikum.pages.RentOrderPage;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class CheckScooterOrderTest {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String dataFields;
    private final String commentField;


    public CheckScooterOrderTest(String firstName, String secondName, String address, String metroStation, String phoneNumber, String dataFields, String commentField) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dataFields = dataFields;
        this.commentField = commentField;
    }


    @Parameterized.Parameters(name = "Проверка Оформления заказа. Кейс: {6}")
    public static Object[][] getCostumersData() {
        return new Object[][]{
                {"Иван", "Иванович", "Карла Фаберже 8", "Чистые пруды", "89112345566", "31.12.2022", "Заказ на станцию Чистые пруды"},
                {"Иван", "Иванович", "Касая аллея 1", "Полежаевская", "+79118234567", "31.12.2022", "Заказ на станцию Полежаевская"},
        };
    }


    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    public void testOrdersStartsToClickOrderTopButton() {
        WebDriver driver = driverRule.getDriver();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOrderTopButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillOrderPage(firstName, secondName, address, metroStation, phoneNumber);
        objOrderPage.setNextButton();
        RentOrderPage objRentOrderPage = new RentOrderPage(driver);
        objRentOrderPage.fillRentOrderPage(dataFields, commentField);
        objRentOrderPage.clickOrderBook();
        objRentOrderPage.clickOrderConfirmButton();
        String orderText = objRentOrderPage.getOrderConfirmText();
        MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    }

    @Test
    public void testOrdersStartsToClickBottomButton() {
        WebDriver driver = driverRule.getDriver();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOrderBottomButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillOrderPage(firstName, secondName, address, metroStation, phoneNumber);
        objOrderPage.setNextButton();
        RentOrderPage objRentOrderPage = new RentOrderPage(driver);
        objRentOrderPage.fillRentOrderPage(dataFields, commentField);
        objRentOrderPage.clickOrderBook();
        objRentOrderPage.clickOrderConfirmButton();
        String orderText = objRentOrderPage.getOrderConfirmText();
        MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    }
}

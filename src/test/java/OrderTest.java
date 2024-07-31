import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobject.MainPage;
import ru.yandex.praktikum.pageobject.OrderPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class OrderTest {
    @RunWith(Parameterized.class)
    public static class OrderTestParameterized {

        private WebDriver driver;
        private final By orderButtonLocator;
        private final String firstName;
        private final String lastName;
        private final String adress;
        private final By stationLocator;
        private final String phoneNumber;
        private final String orderDate;
        private final By daysOfRentLocator;
        private final By colorLocator;
        private final String comment;


        public OrderTestParameterized(By orderButtonLocator, String firstName, String lastName, String adress, By stationLocator, String phoneNumber, String orderDate, By daysOfRentLocator, By colorLocator, String comment) {
            this.orderButtonLocator = orderButtonLocator;
            this.firstName = firstName;
            this.lastName = lastName;
            this.adress = adress;
            this.stationLocator = stationLocator;
            this.phoneNumber = phoneNumber;
            this.orderDate = orderDate;
            this.daysOfRentLocator = daysOfRentLocator;
            this.colorLocator = colorLocator;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] Data() {
            return new Object[][]{
                    {MainPage.HEADER_ORDER_BUTTON, "Иван", "Иванов", "Москва, ул. Льва Толстого, 16", OrderPage.STATION_PARK_KULTURY_INPUT_FIELD, "88888888888", "15.08.2024", OrderPage.RENT_PERIOD_1DAY_INPUT_FIELD, OrderPage.BLACK_COLOR_CHECKBOX, "На пешеходном переходе я спешиваюсь, за это положена скидка?"},
                    {MainPage.BODY_ORDER_BUTTON, "Петр", "Петров", "Москва, ул. Льва Толстого, 17", OrderPage.STATION_PARK_UNIVERSITET_INPUT_FIELD, "77777777777", "30.08.2024", OrderPage.RENT_PERIOD_2DAYS_INPUT_FIELD, OrderPage.GREY_COLOR_CHECKBOX, "Хочу кататься и чувствовать, как ветер развевает мои волосы. Жаль, что я лысый."},
            };
        }

        @Before
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        @After
        public void after() {
            driver.quit();
        }

        @Test
        public void orderCheckWithValidData_getConfirmText() {
            MainPage mainPage = new MainPage(driver);
            OrderPage orderPage = new OrderPage(driver);
            mainPage.open();
            mainPage.scrollToOrderButton(orderButtonLocator);
            mainPage.orderButtonСlick(orderButtonLocator);
            orderPage.enterFirstName(firstName);
            orderPage.enterLastName(lastName);
            orderPage.enterAdress(adress);
            orderPage.StationDropdownFieldClick();
            orderPage.scrollToLocator(stationLocator);
            orderPage.chooseStationClick(stationLocator);
            orderPage.enterPhoneNumber(phoneNumber);
            orderPage.continueButtonClick();
            orderPage.enterOrderDate(orderDate);
            orderPage.calendarActiveDateClick();
            orderPage.rentPeriodClick();
            orderPage.chooseRentPeriodClick(daysOfRentLocator);
            orderPage.chooseColorClick(colorLocator);
            orderPage.enterComment(comment);
            orderPage.finalOrderButtonClick();
            orderPage.confirmOrderButtonClick();
            orderPage.confirmOrderPopupGetText();
            String confirmText = orderPage.confirmOrderPopupGetText();
            System.out.println(confirmText);
            assertTrue(confirmText.contains(orderPage.CORRECT_CONFIRM_TEXT));
        }
    }
}

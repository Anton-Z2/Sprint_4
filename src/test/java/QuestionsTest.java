import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class QuestionsTest {

    @RunWith(Parameterized.class)
    public static class QuestionsTestParameterized {

        private WebDriver driver;
        private final By questionLocator;
        private final By answerLocator;
        private final String expectedAnswerText;

        public QuestionsTestParameterized(By questionLocator, By answerLocator, String expectedAnswerText) {
            this.questionLocator = questionLocator;
            this.answerLocator = answerLocator;
            this.expectedAnswerText = expectedAnswerText;
        }

        @Parameterized.Parameters
        public static Object[][] Data() {
            return new Object[][]{
                    {MainPage.PRICE_PAYMENT_Q, MainPage.PRICE_PAYMENT_A, MainPage.PRICE_PAYMENT_A_TEXT},
                    {MainPage.FEW_SCOOTERS_Q, MainPage.FEW_SCOOTERS_A, MainPage.FEW_SCOOTERS_A_TEXT},
                    {MainPage.RENT_TIME_Q, MainPage.RENT_TIME_A, MainPage.RENT_TIME_A_TEXT},
                    {MainPage.RENT_TODAY_Q, MainPage.RENT_TODAY_A, MainPage.RENT_TODAY_A_TEXT},
                    {MainPage.PROLONG_ORDER_Q, MainPage.PROLONG_ORDER_A, MainPage.PROLONG_ORDER_A_TEXT},
                    {MainPage.SCOOTER_CHARGER_Q, MainPage.SCOOTER_CHARGER_A, MainPage.SCOOTER_CHARGER_A_TEXT},
                    {MainPage.RENT_CANCEL_Q, MainPage.RENT_CANCEL_A, MainPage.RENT_CANCEL_A_TEXT},
                    {MainPage.RENT_LOCATION_Q, MainPage.RENT_LOCATION_A, MainPage.RENT_LOCATION_A_TEXT}
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
        public void checkFAQAnswers_answersMatchExpected() {
            MainPage mainPage = new MainPage(driver);
            mainPage.open();
            mainPage.scrollToQuestions();
            mainPage.clickQuestions(questionLocator);
            String AnswerText = mainPage.getAnswer(answerLocator);
            assertEquals(expectedAnswerText, AnswerText);
        }

    }
}

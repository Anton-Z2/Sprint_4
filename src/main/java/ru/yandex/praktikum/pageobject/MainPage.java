package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    //Кнопка "Заказать" в хедере
    public static final By HEADER_ORDER_BUTTON = By.className("Button_Button__ra12g");
    //Кнопка "Заказать" в теле станицы
    public static final By BODY_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Поле с вопросом о стоимости и оплате
    public static final By PRICE_PAYMENT_Q = By.id("accordion__heading-0");
    // Поле с ответом о стоимости и оплате
    public static final By PRICE_PAYMENT_A = By.id("accordion__panel-0");
    // Корректный текст ответа о стоимости и оплате
    public static final String PRICE_PAYMENT_A_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    // Поле с вопросом об аренде нескольких самокатов
    public static final By FEW_SCOOTERS_Q = By.id("accordion__heading-1");
    // Поле с ответом об аренде нескольких самокатов
    public static final By FEW_SCOOTERS_A = By.id("accordion__panel-1");
    // Корректный текст ответа об аренде нескольких самокатов
    public static final String FEW_SCOOTERS_A_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    // Поле с вопросом о времени аренды
    public static final By RENT_TIME_Q = By.id("accordion__heading-2");
    // Поле с ответом о времени аренды
    public static final By RENT_TIME_A = By.id("accordion__panel-2");
    // Корректный текст ответа о времени аренды
    public static final String RENT_TIME_A_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    // Поле с вопросом об аренде сегодня
    public static final By RENT_TODAY_Q = By.id("accordion__heading-3");
    // Поле с ответом об аренде сегодня
    public static final By RENT_TODAY_A = By.id("accordion__panel-3");
    // Корректный текст ответа об аренде сегодня
    public static final String RENT_TODAY_A_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    // Поле с вопросом о продлении и завершении заказа
    public static final By PROLONG_ORDER_Q = By.id("accordion__heading-4");
    // Поле с ответом о продлении и завершении заказа
    public static final By PROLONG_ORDER_A = By.id("accordion__panel-4");
    // Корректный текст ответа о продлении и завершении заказа
    public static final String PROLONG_ORDER_A_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    // Поле с вопросом о зарядке
    public static final By SCOOTER_CHARGER_Q = By.id("accordion__heading-5");
    // Поле с ответом о зарядке
    public static final By SCOOTER_CHARGER_A = By.id("accordion__panel-5");
    // Корректный текст ответа о зарядке
    public static final String SCOOTER_CHARGER_A_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    // Поле с вопросом об отмене заказа
    public static final By RENT_CANCEL_Q = By.id("accordion__heading-6");
    // Поле с ответом об отмене заказа
    public static final By RENT_CANCEL_A = By.id("accordion__panel-6");
    // Корректный текст ответа об отмене заказа
    public static final String RENT_CANCEL_A_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    // Поле с вопросом о возможной зоне аренды
    public static final By RENT_LOCATION_Q = By.id("accordion__heading-7");
    // Поле с ответом о возможной зоне аренды
    public static final By RENT_LOCATION_A = By.id("accordion__panel-7");
    // Корректный текст ответа о возможной зоне аренды
    public static final String RENT_LOCATION_A_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //url главной страницы
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    //локатор с вопросами/ответами, для прокрутки страницы
    public static final By QUESTIONS_LOCATOR = By.className("Home_FourPart__1uthg");


    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void orderButtonСlick(By orderButtonLocator) {
        driver.findElement(orderButtonLocator).click();
    }

    public void scrollToOrderButton(By orderButtonLocator) {
        WebElement element = driver.findElement(orderButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickQuestions(By questionLocator) {
        driver.findElement(questionLocator).click();

    }

    public void scrollToQuestions() {
        WebElement element = driver.findElement(QUESTIONS_LOCATOR);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getAnswer(By answerLocator) {
        return driver.findElement(answerLocator).getText();
    }
}

package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    //Поле "Имя"
    public static final By FIRSTNAME_INPUT_FIELD = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    //Поле "Фамилия"
    public static final By LASTNAME_INPUT_FIELD = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    //Поле "Адрес"
    public static final By ADRESS_INPUT_FIELD = By.xpath(".//input[contains(@placeholder, 'Адрес: куда привезти заказ')]");
    //Поле "Станция метро"
    public static final By STATION_DROPDOWN_FIELD = By.xpath(".//input[contains(@placeholder, 'Станция метро')]");
    //Поле "Станция метро", вариант "Парк культуры"
    public static final By STATION_PARK_KULTURY_INPUT_FIELD = By.xpath(".//div[contains(text(), 'Парк культуры')]");
    //Поле "Станция метро", вариант "Университет"
    public static final By STATION_PARK_UNIVERSITET_INPUT_FIELD = By.xpath(".//div[contains(text(), 'Университет')]");
    //Поле "Телефон"
    public static final By PHONE_NUMBER_INPUT_FIELD = By.xpath(".//input[contains(@placeholder, 'Телефон: на него позвонит курьер')]");
    //Кнопка "Далее"
    public static final By CONTINUE_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле "Когда привезти самокат"
    public static final By ORDER_DATE_INPUT_FIELD = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    //Поле активной даты в календаре
    public static final By CALENDAR_ACTIVE_DATE = By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]");
    //Поле "Срок аренды"
    public static final By RENT_PERIOD_INPUT_FIELD = By.xpath(".//div[contains(text(), 'Срок аренды')]");
    //Поле "Срок аренды", 1 сутки
    public static final By RENT_PERIOD_1DAY_INPUT_FIELD = By.xpath(".//div[contains(text(), 'сутки')]");
    //Поле "Срок аренды", 2 суток
    public static final By RENT_PERIOD_2DAYS_INPUT_FIELD = By.xpath(".//div[contains(text(), 'двое суток')]");

    //Поле "Цвет самоката" Чекбокс "черный жемчуг"
    public static final By BLACK_COLOR_CHECKBOX = By.xpath(".//input[@id='black']");
    //Поле "Цвет самоката" Чекбокс "серая безысходность"
    public static final By GREY_COLOR_CHECKBOX = By.xpath(".//input[@id='grey']");
    //Поле "Комментарий для курьера"
    public static final By COMMENT_FOR_COURIER_INPUT_FIELD = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    //Кнопка "Заказать"
    public static final By FINAL_ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка "Да" в окне подтверждения заказа
    public static final By CONFIRM_ORDER_BUTTON = By.xpath(".//button[contains(text(), 'Да')]");
    //Окно "Заказ оформлен"
    public static final By CONFIRM_ORDER_POPUP = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Заказ оформлен')]");
    // Текст подтверждения заказа для сравнения
    public static final String CORRECT_CONFIRM_TEXT = "Заказ оформлен";

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(MainPage.PAGE_URL);
    }


    public void enterFirstName(String firstName){
        driver.findElement(OrderPage.FIRSTNAME_INPUT_FIELD).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(OrderPage.LASTNAME_INPUT_FIELD).sendKeys(lastName);
    }
    public void enterAdress(String adress){
        driver.findElement(OrderPage.ADRESS_INPUT_FIELD).sendKeys(adress);
    }
    public void StationDropdownFieldClick(){
        driver.findElement(OrderPage.STATION_DROPDOWN_FIELD).click();
    }
    public void scrollToLocator(By stationLocator) {
        WebElement element = driver.findElement(stationLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
    }
    public void chooseStationClick(By stationLocator){
        driver.findElement(stationLocator).click();
    }
    public void enterPhoneNumber(String phoneNumber){
        driver.findElement(OrderPage.PHONE_NUMBER_INPUT_FIELD).sendKeys(phoneNumber);
    }
    public void continueButtonClick(){
        driver.findElement(OrderPage.CONTINUE_BUTTON).click();
    }
    public void enterOrderDate(String orderDate){
        driver.findElement(OrderPage.ORDER_DATE_INPUT_FIELD).sendKeys(orderDate);
    }
    public void calendarActiveDateClick(){
        driver.findElement(OrderPage.CALENDAR_ACTIVE_DATE).click();
    }
    public void rentPeriodClick(){
        driver.findElement(OrderPage.RENT_PERIOD_INPUT_FIELD).click();
    }
    public void chooseRentPeriodClick(By daysOfRentLocator){
        driver.findElement(daysOfRentLocator).click();
    }
    public void chooseColorClick(By colorLocator){
        driver.findElement(colorLocator).click();
    }
    public void enterComment(String comment){
        driver.findElement(OrderPage.COMMENT_FOR_COURIER_INPUT_FIELD).sendKeys(comment);
    }
    public void finalOrderButtonClick(){
        driver.findElement(OrderPage.FINAL_ORDER_BUTTON).click();
    }
    public void confirmOrderButtonClick(){
        driver.findElement(OrderPage.CONFIRM_ORDER_BUTTON).click();
    }
    public String confirmOrderPopupGetText(){
        return driver.findElement(OrderPage.CONFIRM_ORDER_POPUP).getText();
    }
}

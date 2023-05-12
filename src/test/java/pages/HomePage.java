package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static test.BaseTest.config;

public class HomePage {

    private final By CITY = By.xpath("//input[@placeholder='Куда вы хотите поехать?']");
    private final By ARRIVAL_DATE = By.xpath("//button[@data-testid=\"date-display-field-start\"]");
    private final By FIND_ARRIVAL_DATE = By.xpath("//span[@data-date=\"2023-05-26\"]/span[text()=26]");
    private final By FIND_DATE_OF_DEPARTURE = By.xpath("//span[@data-date=\"2023-05-30\"]/span[text()=30]");
    private final By FIND_BUTTON = By.xpath("//button[@type='submit']");
    private final By ACCEPT_COOKIES_BUTTON = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private final By DROP_DOWN_LIST_ITEMS = By.xpath("//div[@class='a40619bfbe']");
    private final By CLOSE_WINDOW = By.xpath("//button[@aria-label=\"Скрыть меню входа в аккаунт.\"]");
    private final By BUTTON_PICKUP_CAR = By.cssSelector("a#cars");

   // @Description("Открываем главную страницу сайта Booking.com")
    @Step("зайти на сайт https://www.booking.com/")
    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }

   // @Description("Нажимаем на кнопку «Принять всё» в всплывающем окне с cookies")
    @Step("закрыть окно GENIUS")
    public HomePage closeGenius() {
        $(CLOSE_WINDOW).click();
        return this;
    }

    @Step("подтвердить cookies")
    public HomePage acceptCookies() {
        $(ACCEPT_COOKIES_BUTTON).click();
        return this;
    }

  //  @Description("Вводим в поиске «Будапешт» и нажимаем на соответсвующий элемент выпадающего списка")
    @Step("ввести в поиске любой город(заграничный)")
    public HomePage findByCity(String cityName) {
        $(CITY).sendKeys(cityName);
        $$(DROP_DOWN_LIST_ITEMS).get(0).shouldHave(Condition.text(cityName));
        return this;
    }

  //  @Description("Выбираем в календаре даты с 26 мая по 30 мая")
    @Step("выбрать случайные даты")
    public HomePage findByArrivalDate() {
        $(ARRIVAL_DATE).click();
        $(FIND_ARRIVAL_DATE).click();
        return this;
    }

  //  @Description("Нажимаем кнопку «Найти» и осуществляем поиск по введенным данным")
    @Step("нажать на кнопку «Найти»")
    public HomePage findByDateOfDeparture() {
        $(FIND_DATE_OF_DEPARTURE).click();
        $(FIND_BUTTON).click();
        return this;
    }

    @Step("перейти на вкладку «Аренда машин»")
    public HomePage pickupCar() {
        $(BUTTON_PICKUP_CAR).click();
        return this;
    }

}
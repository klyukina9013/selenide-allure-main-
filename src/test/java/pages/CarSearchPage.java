package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static test.BaseTest.config;

public class CarSearchPage {

 //   private final By PLACE = By.xpath("//input[@data-testid=\"searchbox-toolbox-fts-pickup\"]");
 //   private final By DROP_DOWN_LIST = By.xpath("//div[@class=\"searchbox-toolbox-fts__suggestion-content\"]/div[text()=\"Лондон\"]");
    private final By POPULAR_TOWN = By.xpath("(//div[@class=\"ccff2b4c43 cfc0860887\"]/a)[1]");
    private final By POPULAR_PLACE = By.xpath("(//ul[@class=\"fff8c74b55 cb9e386163\"]//a)[1]");
    private final By POPULAR_PLACE2 = By.xpath("(//div[@class=\"a826ba81c4 fe821aea6c fa2f36ad22 afd256fc79 d08f526e0d ed11e24d01 ef9845d4b3 a5a6bbfc1e\"])[2]");
    private final By TEXT_PAGE_ONE = By.xpath("//h2[contains(text(), \"Популярные\")]");
    private final By TEXT_PAGE_TWO = By.xpath("//h2[contains(text(), \"Рекомендованные\")]");
    private final By TEXT = By.xpath("//h2[contains(text(), \"Найдите отличные\")]");

    private final By BUTTON_DATE = By.xpath("(//button[@role=\"button\"])[1]");
    private final By ARRIVAL_DATE = By.xpath("(//td[@data-id=\"1684195200000\"]/span)[1]");
    private final By DATE_OF_DEPARTURE = By.xpath("(//td[@data-id=\"1684368000000\"]/span)[2]");
    private final By FIND_BUTTON_FOR_CAR = By.xpath("//button[@data-sb-id=\"main\"]");
    private final By CLOSE_BUTTON = By.xpath("//button[@data-command=\"noop\"]");
    private final By SEARCH = By.xpath("//p[@class='bui-text bui-f-font-display_three bui-f-color-black']");
    private final By BUTTON_ALL_VARIANTS = By.xpath("(//a[@class=\"result__bui-btn result__bui-btn--primary\"])[1]");
    private final By CHECK_TEXT = By.xpath("//span[@class=\"sb-searchbox__title-text\"]");


    @Step("Спуститься вниз страниц и выбрать первый город из «Популярные направления для аренды автомобиля»")
    public CarSearchPage findByTown() {
        $(TEXT_PAGE_ONE).scrollTo();
        $(POPULAR_TOWN).click();
        return this;
    }

    @Step("Спуститься вниз страниц и выбрать первое место из «Рекомендованные места получения автомобиля»")
    public CarSearchPage findByPlace() {
        $(TEXT).shouldBe(visible, Duration.ofSeconds(10));
        Selenide.sleep(20000);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        $(TEXT_PAGE_TWO).scrollTo();
        $(POPULAR_PLACE2).click();
        return this;
    }

  /*  @Step("выбрать даты получения 16-18 мая")
    public CarSearchPage findByDates() {
        $(CLOSE_BUTTON).click();
        $(BUTTON_DATE).click();
        $(ARRIVAL_DATE).click();
        $(DATE_OF_DEPARTURE).click();
        $(CHECK_TEXT).shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Нажать «Проверить цены»")
    public CarSearchPage findDifferentCars() {
        $(CLOSE_BUTTON).click();
        $(FIND_BUTTON_FOR_CAR).click();
        return this;
    }


    @Step("Нажать на «Показать все авто» на веррхней карточке")
    public CarSearchPage showAllVariants() {
        $(BUTTON_ALL_VARIANTS).click();
        $(SEARCH).shouldBe(visible);
        $(SEARCH).shouldBe(hidden);
        return this;
    }**/


}

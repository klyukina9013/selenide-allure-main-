package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HotelSearchPage {

  public static final String HOTEL_NAME = "Hotel name";
  public static final String OVERALL_SCORE = "Overall score";
  private final By SHOW_ON_THE_MAP = By.xpath(
      "//span[@class=\"fc63351294 a822bdf511 d4b6b7a9e7 f7db01295e c334e6f658 f4605622ad d2c52b10ce\"]");
  private static final String nameOfHotel = "span.map-card__title-link";
  private static final String ratingOfHotel = "div.bui-review-score__badge";
  private static final String reviewsOfHotel = "div.bui-review-score__text";
  private static final String costOfHotel = "span.prco-valign-middle-helper";


  private final By CARDS_LEFT = By.xpath(
      "//*[@data-testid='property-list-map-card'] | //*[@class='map-card__container']");
  private final By LOADER = By.xpath(
      "//*[@class='map_left_cards__loading-spinner'] | //*[@class='a4dea99de5']");
  private final By HEADER_TITLE = By.xpath(
      ".//*[@data-testid='header-title'] | .//*[@class='map-card__title']");
  private final By MODAL = By.xpath("//*[@class='map_with_list__container']");
  private final By SCORE = By.xpath(
      ".//*[starts-with(@aria-label,'Scored') or starts-with(@aria-label,'Оценка')]");
  private final By GEO_POSITION = By.xpath(
      "//div[@class='hotel-marker hotel-marker--likable']/parent::div");


 // @Description("Нажимаем кнопку «Найти» и осуществляем поиск по введенным данным")
  @Step("нажать на кнопку «Показать на карте»")
  public HotelSearchPage showOnTheMap() {
    $(SHOW_ON_THE_MAP).click();
    return this;
  }

  @Step("нажать на прыгающий маркер на карте")
  public HotelSearchPage chooseGeoPosition() {
    $(GEO_POSITION).click();
    return this;
  }

  @Step("навести курсор на первый отель(карточка слева) и сохранить(в переменные) название отеля, количество звезд, среднюю оценку, количество отзывов, стоимость")
  @Description("Проверяем, что хотя бы одна карточка с блоком информации про отель отображается")
  @DisplayName("проверка загрузки страницы")
  public HotelSearchPage chooseCard(Map<String, String> hotelData) {
    SelenideElement modal = $(MODAL).shouldBe(visible, Duration.ofSeconds(10));
    $(LOADER).shouldBe(visible, Duration.ofSeconds(10));
    SelenideElement card = $$(CARDS_LEFT)
        .shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10))
        .first()
        .shouldBe(visible);
    String hotelName = card.$(HEADER_TITLE).getText();
    String score = card.$(SCORE).getText();
    hotelData.put(HOTEL_NAME, hotelName);
    hotelData.put(OVERALL_SCORE, score);
    card.hover();
    return this;
  }

  @Step("на открывшейся странице отеля проверить название отеля, количество звезд, среднюю оценку, количество отзывов и стоимость")
  public HotelSearchPage allElementsAreOnThePageShouldExist(Map<String, String> hotelData) {
    SelenideElement hotelTitle = $(nameOfHotel).should(exist);
    Assertions.assertEquals(hotelTitle.getText(), hotelData.get(HOTEL_NAME));
    $(ratingOfHotel).shouldBe(exist);
    $(reviewsOfHotel).shouldBe(exist);
    $(costOfHotel).shouldBe(exist);
    return this;
  }


}
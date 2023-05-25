package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.HotelSearchPage;

import java.util.HashMap;
import java.util.Map;

@Epic("UI test")
@Story("Поиск отеля по геопозиции на карте")
@Link(name = "Тестируемый сервис", url = "https://www.booking.com/")
@Severity(SeverityLevel.NORMAL) /*указала такой уровень важности, т.к.
это не единственный способ перейти на страницу с отелем**/

class HomeWorkTest extends BaseTest {
    @Test
    void hotels() {
        String cityName = "Будапешт";

        HomePage homePage = new HomePage();
        HotelSearchPage hotelSearchPage = new HotelSearchPage();

        homePage.openPage()
               // .acceptCookies()
                .findByCity(cityName)
                .findByArrivalDate()
                .findByDateOfDeparture();
        Map<String, String> hotelData = new HashMap<>();
        hotelSearchPage.showOnTheMap()
            .chooseCard(hotelData)
            .chooseGeoPosition()
            .allElementsAreOnThePageShouldExist(hotelData);
    }
}



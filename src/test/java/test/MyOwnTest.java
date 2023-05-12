package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.CarSearchPage;
import pages.ChoiceOfCarsPage;
import pages.DataOfUsersPage;
import pages.HomePage;



@Epic("UI test")
@Story("Поиск отеля по геопозиции на карте")
@Link(name = "Тестируемый сервис", url = "https://www.booking.com/")
@Severity(SeverityLevel.BLOCKER) // т.к. иначе отправить на электронную посту нельзя
@Flaky
class MyOwnTest extends BaseTest {

    @Test
    void xCar() {
        String eMail = "azaza9013@mail.ru";
        String firstName = "Иван";
        String secondName = "Иванов";
        String telephone = "89999999999";


        HomePage homePage = new HomePage();
        CarSearchPage carSearchPlace = new CarSearchPage();
        ChoiceOfCarsPage choiceOfCarsPage = new ChoiceOfCarsPage();
        DataOfUsersPage dataOfUsersPage = new DataOfUsersPage();


        homePage.openPage()
                .acceptCookies()
                //.closeGenius()
                .pickupCar();

        carSearchPlace.findByTown().
                findByPlace();


        choiceOfCarsPage.sendOnEMail();

        dataOfUsersPage.selectSex()
                .acceptCookies()
                .writeEMail(eMail)
                .writeFirstName(firstName)
                .writeSecondName(secondName)
                .writeTelephone(telephone)
                .sendData();

    }
}




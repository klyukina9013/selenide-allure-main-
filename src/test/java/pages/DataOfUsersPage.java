package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DataOfUsersPage {

    private final By MS = By.xpath("(//select[@id=\"title\"]/option)[2]");
    private final By EMAIL_FIELD = By.xpath("//input[@id=\"email\"]");
    private final By FIRST_NAME_FIELD = By.xpath("//input[@id=\"firstname\"]");
    private final By SECOND_NAME_FIELD = By.xpath("//input[@id=\"surname\"]");
    private final By TELEPHONE_FIELD = By.xpath("//input[@id=\"phone\"]");
    private final By BUTTON_SEND = By.xpath("//button[@class=\"bui-button bui-button--primary bui-button--large bui-button--wide \"]");
    private final By ACCEPT_COOKIES = By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]");

    @Step("Подтвердить Cookies")
    public DataOfUsersPage acceptCookies() {
        $(ACCEPT_COOKIES).click();
        return this;
    }

    @Step("Выбрать обращение к водителю")
    public DataOfUsersPage selectSex() {
        $(MS).click();
        return this;
    }

    @Step("Написать eMail")
    public DataOfUsersPage writeEMail(String eMail) {
        $(EMAIL_FIELD).sendKeys(eMail);
        return this;
    }

    @Step("Написать имя")
    public DataOfUsersPage writeFirstName(String firstName) {
        $(FIRST_NAME_FIELD).sendKeys(firstName);
        return this;
    }

    @Step("Написать фамилию")
    public DataOfUsersPage writeSecondName(String secondName) {
        $(SECOND_NAME_FIELD).sendKeys(secondName);
        return this;
    }

    @Step("Написать телефон")
    public DataOfUsersPage writeTelephone(String telephone) {
        $(TELEPHONE_FIELD).sendKeys(telephone);
        return this;
    }

    @Step("Нажать на кнопку «Отправить»")
    public DataOfUsersPage sendData() {
        $(BUTTON_SEND).click();
        return this;
    }

}

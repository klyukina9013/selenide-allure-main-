package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class ChoiceOfCarsPage {

    private final By BUTTON_SEND_ON_EMAIL = By.xpath("(//button[@class=\"bui-button bui-button--secondary bui-button--wide bui-u-pull-end\"])[1]");

    @Step("Нажать на кнопку «Сохранить на будущее»")
    public ChoiceOfCarsPage sendOnEMail() {
        switchTo().window(1);
        $(BUTTON_SEND_ON_EMAIL).scrollTo();
        $(BUTTON_SEND_ON_EMAIL).click();
        return this;
    }
}

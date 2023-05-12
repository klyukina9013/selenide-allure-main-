package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1366x768";
        Configuration.timeout = 7000;
        Configuration.pageLoadTimeout = 40000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\",\"--remote-debugging-port=9222\", \"--ignore-ssl-errors=yes\", \"--ignore-certificate-errors\"");
    }

   @AfterAll
    public static void turnDown() {
        Selenide.closeWebDriver();
    }
}
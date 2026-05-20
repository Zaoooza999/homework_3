package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;

public class TestBase {

    @BeforeAll
    static void setupConfig() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("windowSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "147.0.7727.138");
        Configuration.baseUrl = System.getProperty("environmentUrl");//https://qa-guru.github.io
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = System.getProperty("selenoidUrl");//https://user1:1234@selenoid.autotests.cloud/wd/hub
    }

    @BeforeEach
    void addListener(){
        SelenideLogger.removeListener("allure");
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true)
                .savePageSource(true));;
    }

    @AfterAll
    static void cleanupAllureReports() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    void addAttachments() {
        Attach.attachScreenshot("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Attach.pageHtmlSource();
    }

    @AfterEach
    void tearDownWebDriver() {
        Selenide.closeWebDriver();
    }
}

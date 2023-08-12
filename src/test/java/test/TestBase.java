package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.SidebarPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    SidebarPage sidebarPage = new SidebarPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://render.ru/ru";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
        Configuration.remote ="https://user1:1234@selenoid.autotests.cloud/wd/hub";
//        Configuration.timeout = 30000;
    }
    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}

package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.SidebarPage;

public class TestBase {
    SidebarPage sidebarPage = new SidebarPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
//        Configuration.timeout = 30000;
    }
}

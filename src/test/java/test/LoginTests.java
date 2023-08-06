package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends TestBase{

    //wolic45238@mliok.com
    //fcff612052dd4fe6

    @Test
    @DisplayName("Successful authorization")
    void loginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setEmail()
                .setPassword()
                .clickSubmitButton().openSidebar().openBlogsPage();
//
//
    }
}

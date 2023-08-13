package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class LoginTests extends TestBase {

    //wolic45238@mliok.com
    //fcff612052dd4fe6

    @Test
    @Tag("login_tests")
    @DisplayName("Successful authorization test")
    void loginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setEmail(accountData.getEmail())
                .setPassword(accountData.getPassword())
                .clickSubmitButton()
                .openUserDropdownMenu()
                .checkUserName("testUser testUser");
        //todo сделать logout
    }

//    @Disabled("Продумать, как реализовать проверку")
    @Test
    @Tag("login_tests")
    @DisplayName("Error authorization test")
    void errorLoginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setEmail(accountData.getEmail())
                .setPassword("12345")
                .clickSubmitButton();
//                todo .checkErrorAuthMessage();
    }

    @Test
    @Tag("login_tests")
    @DisplayName("Missed password authorization test")
    void missedPasswordLoginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setEmail(accountData.getEmail())
                .tryClickSubmitButton();
    }

    @Test
    @Tag("login_tests")
    @DisplayName("Missed email authorization test")
    void missedEmailLoginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setPassword(accountData.getPassword())
                .tryClickSubmitButton();
    }
}

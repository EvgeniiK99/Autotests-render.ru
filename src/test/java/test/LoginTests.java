package test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends TestBase {

    //wolic45238@mliok.com
    //fcff612052dd4fe6

    @Test
    @DisplayName("Successful authorization")
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

    @Disabled("Продумать, как реализовать проверку")
    @Test
    @DisplayName("Error authorization")
    void errorLoginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setEmail("wolic45238@mliok.com")
                .setPassword("12345")
                .clickSubmitButton();
//                todo .checkErrorAuthMessage();
    }

    @Test
    @DisplayName("Missed password authorization")
    void missedPasswordLoginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setEmail("wolic45238@mliok.com")
                .tryClickSubmitButton();
    }

    @Test
    @DisplayName("Missed email authorization")
    void missedEmailLoginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setPassword("fcff612052dd4fe6")
                .tryClickSubmitButton();
    }
}

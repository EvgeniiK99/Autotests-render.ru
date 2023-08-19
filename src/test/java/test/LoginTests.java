package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {
    @Test
    @Tag("login_tests")
    @DisplayName("Successful authorization test")
    void loginTest() {
        mainPage
                .openMainPage();
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setEmail(accountData.getEmail())
                .setPassword(accountData.getPassword())
                .clickSubmitButton();
        sidebarPage
                .openUserDropdownMenu()
                .checkUserName("testUser testUser");
    }

    @Test
    @Tag("login_tests")
    @DisplayName("Error authorization test")
    void errorLoginTest() {
        mainPage
                .openMainPage();
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setEmail(accountData.getEmail())
                .setPassword("12345")
                .clickSubmitButton()
                .checkErrorAuthMessage("Ошибка авторизации");
    }

    @Test
    @Tag("login_tests")
    @DisplayName("Missed password authorization test")
    void missedPasswordLoginTest() {
        mainPage
                .openMainPage();
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
        mainPage
                .openMainPage();
        sidebarPage
                .openSidebar()
                .openLoginWindow()
                .setPassword(accountData.getPassword())
                .tryClickSubmitButton();
    }
}

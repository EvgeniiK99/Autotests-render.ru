package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.MINOR;

@Epic("UI_Tests")
@Feature("Authorizations")
public class LoginTests extends TestBase {
    @Test
    @Tag("login_tests")
    @Owner("Evgenii Klimashin")
    @Severity(BLOCKER)
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
    @Owner("Evgenii Klimashin")
    @Severity(BLOCKER)
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
    @Owner("Evgenii Klimashin")
    @Severity(BLOCKER)
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
    @Owner("Evgenii Klimashin")
    @Severity(MINOR)
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

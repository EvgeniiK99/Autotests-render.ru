package web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.MINOR;

@Owner("Evgenii Klimashin")
@Tag("login_tests")
@Epic("UI_Tests")
@Feature("Authorizations")
public class LoginTests extends TestBase {

    @Test
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
package web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("Evgenii Klimashin")
@Severity(NORMAL)
@Epic("UI_Tests")
@Feature("Main page")
public class MainPageTests extends TestBase {

    @CsvSource({
            "English, English (EN), Worldwide CG resource",
            "Deutsch, Deutsch (DE), Weltweite CG Ressourcen",
            "Português, Português (PT), Recursos mundiais de CG",
            "Русский, Русский (RU), Крупнейший информационный ресурс по компьютерной графике"
    })
    @ParameterizedTest(name = "{0}")
    @DisplayName("Change language test - ")
    void changeLanguageTests(String language, String languageCode, String header) {
        mainPage
                .openMainPage();
        sidebarPage
                .openSidebar()
                .changeLanguage(languageCode)
                .openSidebar()
                .checkLanguage(language, header);
    }
}
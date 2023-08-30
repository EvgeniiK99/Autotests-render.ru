package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Epic("UI_Tests")
@Feature("Main page")
public class MainPageTests extends TestBase {
    @Owner("Evgenii Klimashin")
    @Severity(NORMAL)
    @CsvSource({
            "English, English (EN), Worldwide CG resource",
            "Deutsch, Deutsch (DE), Weltweite CG Ressourcen",
            "Português, Português (PT), Recursos mundiais de CG",
            "Русский, Русский (RU), Крупнейший информационный ресурс по компьютерной графике"
    })
    @DisplayName("Change language test - ")
    @ParameterizedTest(name = "{0}")
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

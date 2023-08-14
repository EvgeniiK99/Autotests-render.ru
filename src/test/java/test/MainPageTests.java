package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MainPageTests extends TestBase{

    @CsvSource({
            "English, English (EN)",
            "Deutsch, Deutsch (DE)",
            "Português, Português (PT)",
            "Русский, Русский (RU)"
    })
    @DisplayName("Change language test - ")
    @ParameterizedTest(name = "{0}")
    void changeLanguageTests(String language, String languageCode) {
        mainPage
                .openMainPage();
        sidebarPage
                .openSidebar()
                .changeLanguage(languageCode)
                .openSidebar()
                .checkLanguage(language);
    }
}

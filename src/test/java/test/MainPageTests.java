package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTests extends TestBase{

    @CsvSource({
            "English, English (EN)",
            "Deutsch, Deutsch (DE)",
            "Português, Português (PT)",
            "Русский, Русский (RU)"
    })
    @DisplayName("Change language - {0}")
    @ParameterizedTest(name = "Change language - {0}")
    void changeLanguageTests(String language, String languageCode) {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .changeLanguage(languageCode)
                .openSidebar()
                .checkLanguage(language);
    }
}

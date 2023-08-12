package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class BlogsPageTests extends TestBase {
    @Test
    @DisplayName("Use filter by Name")
    void missedPasswordLoginTest() {
        open("https://render.ru");
        sidebarPage
                .openSidebar()
                .openBlogsPage()
                .openFiltersAndSearch()
                .setValueInFilterByName("Август 2023")
                .closeFiltersAndSearch()
                .checkBlogInList("Август 2023");
    }
}

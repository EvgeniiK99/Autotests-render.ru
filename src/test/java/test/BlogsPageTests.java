package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BlogsPage;

import static com.codeborne.selenide.Selenide.open;

public class BlogsPageTests extends TestBase {
    @Test
    @Feature("Filters")
    @Story("Successful use filter by Name")
    @DisplayName("Use filter by Name")
    void usingFilterByName() {
        open("/section");
        new BlogsPage()
                .openFiltersAndSearch()
                .setValueInFilterByName("Август 2023")
                .closeFiltersAndSearch()
                .checkBlogInList("Август 2023");
    }
}

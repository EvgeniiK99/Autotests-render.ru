package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BlogsPage;

public class BlogsPageTests extends TestBase {
    @Test
    @Tag("blogs_tests")
    @Feature("Filters")
    @Story("Successful use filter by Name")
    @DisplayName("Use filter by Name")
    void usingFilterByName() {
        new BlogsPage()
                .openBlogsPage()
                .openFiltersAndSearch()
                .setValueInFilterByName("Август 2023")
                .closeFiltersAndSearch()
                .checkBlogInList("Август 2023");
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BlogsPage {
    SelenideElement filterButton = $(".blog-list__filter__button");

    public BlogsPage openFiltersAndSearch() {
        filterButton.click();
        return this;
    }
}

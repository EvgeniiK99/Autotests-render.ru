package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BlogsPage extends SidebarPage {
    SelenideElement
            filterButton = $(".blog-list__filter__button"),
            fieldFilterByName = $(".blog-list__filter__name").find("input"),
            blogList = $("#packery");



    @Step("Open filters")
    public BlogsPage openFiltersAndSearch() {
        filterButton.click();
        return this;
    }
    @Step("Close filters")
    public BlogsPage closeFiltersAndSearch() {
        //todo оптимизировать
        $(byText("Закрыть фильтры")).click();
        return this;
    }
    @Step("Use filter by Name")
    public BlogsPage setValueInFilterByName(String value) {
        fieldFilterByName.setValue(value);
        return this;
    }
    @Step("Check Blog in list")
    public BlogsPage checkBlogInList(String value) {
        blogList.$(byText(value)).shouldBe(visible);
        return this;
    }
}

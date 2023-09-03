package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BlogsPage {

    SelenideElement
            filterButton = $(".blog-list__filter__button"),
            closeFilterButton = $(byText("Закрыть фильтры")),
            fieldFilterByName = $(".blog-list__filter__name").find("input"),
            listOfBlogs = $("#packery"),
            favoriteButton = $(".blog-post__toolbar__favorite");

    @Step("Open Blogs page")
    public BlogsPage openBlogsPage() {
        open("/section");
        return this;
    }

    @Step("Open filters")
    public BlogsPage openFiltersAndSearch() {
        filterButton.click();
        return this;
    }

    @Step("Close filters")
    public BlogsPage closeFiltersAndSearch() {
        closeFilterButton.click();
        return this;
    }

    @Step("Use filter by Name")
    public BlogsPage setValueInFilterByName(String value) {
        fieldFilterByName.setValue(value);
        return this;
    }

    @Step("Check Blog in list")
    public BlogsPage checkBlogInList(String value) {
        listOfBlogs.$(byText(value)).shouldBe(visible);
        return this;
    }

    @Step("Open Blog")
    public BlogsPage openBlog(Integer blogId) {
        open("/blogs/post/" + blogId);
        return this;
    }

    @Step("Add Blog to favorite")
    public BlogsPage addBlogToFavorite() {
        favoriteButton.click();
        return this;
    }

    @Step("Check blog is in favorite")
    public BlogsPage checkBlogIsInFavorite() {
        favoriteButton.shouldHave(cssClass("blog-post__toolbar__in-favorites"));
        return this;
    }

    @Step("Delete blog from favorite")
    public BlogsPage deleteBlogFromFavorite() {
        favoriteButton.click();
        return this;
    }

    @Step("Check blog is not in favorite")
    public BlogsPage checkBlogIsNotInFavorite() {
        favoriteButton.shouldNotHave(cssClass("blog-post__toolbar__in-favorites"));
        return this;
    }
}

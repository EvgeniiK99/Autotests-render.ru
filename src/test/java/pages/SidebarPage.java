package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SidebarPage {

    SelenideElement
            sidebar = $(".main-menu");
    SelenideElement userMenu =  $(".menu__username");
    SelenideElement blogsMenu = $(byText("БЛОГИ"));

    public SidebarPage openSidebar() {
        sidebar.hover();
        return this;
    }
    public LoginPage openLoginWindow() {
        LoginPage loginPage = new LoginPage();
        userMenu.click();
        return loginPage;
    }
    public SidebarPage openBlogsPage() {
        blogsMenu.click();
        return this;
    }
}



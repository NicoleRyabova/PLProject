package com.appflowy.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {//
    @FindBy(xpath = "//button[@class='navigation-item navigation-item-product']")
    public SelenideElement productNavigationButton;
    @FindBy(xpath = "//button[@class='navigation-item navigation-item-download']")
    public SelenideElement downloadNavigationButton;
    @FindBy(xpath = "//button[@class='navigation-item navigation-item-community']")
    public SelenideElement communityNavigationButton;
    @FindBy(xpath = "//button[@class='navigation-item navigation-item-resources']")
    public SelenideElement resourcesNavigationButton;
    @FindBy(xpath = "//button[@class='navigation-item navigation-item-pricing']")
    public SelenideElement pricingNavigationButton;
    @FindBy(xpath = "//div[@class='menu-popover-content']")
    public SelenideElement downloadPopoverMenu; //появляющееся меню при наведении на кнопк download
    @FindBy(xpath = "div.menu-popover-content div.item-name")
    public ElementsCollection downloadPopoverMenuElements; // элементы на меню download

    private final String address = "https://appflowy.com/";
    private final String[] navigationBarLinks = {"https://appflowy.com/download", "https://appflowy.com/download#ios-and-android", "https://appflowy.com/download#macOS", "https://appflowy.com/pricing"};
    public final String[] expectedCategoriesInCommunityButton = {"Community", "Connect with us", "Featured"};
    public final String[] expectedCategoriesInResourcesButton = {"Docs", "Learn", "Featured"};


    public String getAddress() {
        return address;
    }
    public String getNavigationBarLink(int index) {
        if (index >= 0 && index < navigationBarLinks.length) {
            return navigationBarLinks[index];
        } else {
            throw new IllegalArgumentException("Не валидный индекс: " + index);
        }
    }


}

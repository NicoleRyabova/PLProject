package com.appflowy.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ProductPage { //Класс с кнопками и атрибутами главной страницы сайта

    // КНОПКИ НАВИГАЦИИ
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
    public SelenideElement downloadPopoverMenu; //появляющееся меню при наведении на кнопку download
    @FindBy(xpath = "//div[@class = 'item-name']")
    public ElementsCollection downloadPopoverMenuElements; // элементы на меню download

    public final String[] expectedCategoriesInCommunityButton = {"Community", "Connect with us", "Featured"};
    public final String[] expectedCategoriesInResourcesButton = {"Docs", "Learn", "Featured"};
}

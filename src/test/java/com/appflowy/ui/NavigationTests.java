package com.appflowy.ui;

import com.appflowy.core.BaseClass;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

@Epic("UI Тесты AppFlowy")
@Feature("Тесты навигации")
public class NavigationTests extends BaseClass {
    @BeforeMethod
    public void beforeMethod(){
        Selenide.open(address.getAddress());

    }
    @Test(description = "Тест навигации по разделам сайта")
    public void findNavigationItemsTest(){
        productPage.productNavigationButton.click(); // кликаем по 1 кнопке
        webdriver().shouldHave(url(address.getAddress())); // проверяем ссылку
        //Нажимаем на кнопку Download
        productPage.downloadNavigationButton.click();
        webdriver().shouldHave(url(address.getNavigationBarLink(0))); // проверяем ссылку на "https://appflowy.com/download"

        // Проверяем, что появилось выпадающее меню
        productPage.downloadNavigationButton.hover();
        productPage.downloadPopoverMenu.shouldBe(Condition.visible);

        // Для кнопки iOS & Android
        productPage.downloadPopoverMenuElements.get(0)
                .shouldBe(visible)
                .shouldHave(exactText("iOS & Android")).click();
        webdriver().shouldHave(url(address.getNavigationBarLink(1))); // проверяем ссылку на  "https://appflowy.com/download#ios-and-android"

        // Для кнопки macOS & Windows & Linux
        productPage.downloadNavigationButton.hover();
        productPage.downloadPopoverMenuElements.get(1)
                .shouldBe(visible)
                .shouldHave(exactText("macOS & Windows & Linux")).click();
        webdriver().shouldHave(url(address.getNavigationBarLink(2))); // проверяем ссылку на  "https://appflowy.com/download#macOS"

        productPage.pricingNavigationButton.click();
        webdriver().shouldHave(url(address.getNavigationBarLink(3))); // проверяем ссылку на  "https://appflowy.com/pricing"
    }
}

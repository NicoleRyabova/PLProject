package com.appflowy.core;

import com.appflowy.ui.pages.LoginPage;
import com.appflowy.ui.pages.ProductPage;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.page;

public class BaseClass {
  protected LoginPage loginPage;
  protected ProductPage productPage;
    @BeforeSuite(alwaysRun = true)
    public void beforeSuit() {
        loginPage = page(LoginPage.class);
        productPage = page(ProductPage.class);
    }
}

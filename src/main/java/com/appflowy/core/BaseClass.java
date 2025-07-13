package com.appflowy.core;

import com.appflowy.api.DataForBody;
import com.appflowy.ui.pages.LoginPage;
import com.appflowy.ui.pages.ProductPage;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.page;

public class BaseClass {
  protected LoginPage loginPage;
  protected ProductPage productPage;
  protected Address address;
  protected DataForBody dataForBody;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuit() {
        loginPage = page(LoginPage.class);
        productPage = page(ProductPage.class);
        address = page(Address.class);
        dataForBody = page(DataForBody.class);
    }
}

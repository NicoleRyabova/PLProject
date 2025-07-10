package com.appflowy.ui;

import com.appflowy.core.BaseClass;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

@Epic("UI Тесты AppFlowy")
@Feature("Тесты авторизации")
public class AuthorizationTests extends BaseClass {

    @BeforeMethod
    public void beforeMethod(){
        Selenide.open(productPage.getAddress());

    }
    @Test(description = "Проверка кнопок регистрации")
    public void findButtonsForStartForFreeTest(){
        loginPage.startForFreeNavigation.should(exist);
        loginPage.downloadNow.shouldHave(text("Download now"));
        loginPage.startForFree2.shouldHave(exactText("Start for free"));
    }

    @Test(description = "Проверка кол-ва кнопок 'Continue with'")
    public void ContinueWithTest(){
        loginPage.startForFreeNavigation.click();
        webdriver().shouldHave(url(loginPage.getRegistrationAddress()));

        for (int i = 0; i <= 3; i++) {
            loginPage.continueWithElement.get(i)
                    .shouldHave(text(loginPage.expectedTextsOnLoginPageStartingElements[i]));
            if (i == 3){
                loginPage.continueWithElement.get(i).click();
                for (int k = 0; k<= 4; k++){
                    loginPage.continueWithElement.get(k)
                            .shouldHave(text(loginPage.expectedTextsOnLoginPageAllElements[k]));
                }
            }
        }
    }

    @Test(description = "Тест валидации пустого email")
    public void emptyEmailTest(){
        loginPage.startForFreeNavigation.click();
        webdriver().shouldHave(url(loginPage.getRegistrationAddress()));
        loginPage.continueWithElement.get(0).click();
        $x("//section[@aria-label='Notifications alt+T']").shouldBe(visible);
    }
}

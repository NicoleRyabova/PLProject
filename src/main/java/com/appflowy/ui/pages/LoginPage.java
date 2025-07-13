package com.appflowy.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class LoginPage { //СТРАНИЦА ДЛЯ АВТОРИЗАЦИИ
    public final String[] expectedTextsOnLoginPageStartingElements = {"Продолжить с эл. почтой", "Продолжить с Google", "Continue with Apple","More Options" };
    public final String[] expectedTextsOnLoginPageAllElements = {"Продолжить с эл. почтой", "Продолжить с Google", "Continue with Apple","Продолжить с GitHub", "Продолжить с Discord" };

    //КНОПКИ НА СТРАНИЦЕ РЕГИСТРАЦИИ
    @FindBy(xpath = "//input[@type='email']")
    public SelenideElement emailInputForRegistration;
    @FindBy(xpath = "//button[@data-slot='button']")
    public ElementsCollection continueWithElement;// здесь кнопки "Продолжить с эл.почтой", "Продолжить с Google" и тд.
    @FindBy(xpath="//button[@class='download-btn download-free-btn']")
    public SelenideElement startForFreeNavigation;
    @FindBy(css ="button.bg-white")
    public SelenideElement startForFree2;
    @FindBy(css = "button.bg-primary")
    public SelenideElement downloadNow;
}

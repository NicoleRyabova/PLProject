package com.appflowy.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String addressForRegistration = "https://appflowy.com/app";
    public final String[] expectedTextsOnLoginPageStartingElements = {"Продолжить с эл. почтой", "Продолжить с Google", "Continue with Apple","More Options" };
    public final String[] expectedTextsOnLoginPageAllElements = {"Продолжить с эл. почтой", "Продолжить с Google", "Continue with Apple","Продолжить с GitHub", "Продолжить с Discord" };

    @FindBy(xpath = "//input[@type='email']")
    public SelenideElement emailInputForRegistration;
    @FindBy(xpath = "//button[@data-slot='button']")
    public SelenideElement continueWithEmailRegistration;
    @FindBy(xpath="//button[@class='download-btn download-free-btn']")
    public SelenideElement startForFreeNavigation;
    @FindBy(css ="button.bg-white")
    public SelenideElement startForFree2;
    @FindBy(css = "button[data-slot='button']")
    public ElementsCollection continueWithElement;

    public String getRegistrationAddress(){
        return addressForRegistration;
    }

}

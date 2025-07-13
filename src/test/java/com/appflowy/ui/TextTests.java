package com.appflowy.ui;

import com.appflowy.core.BaseClass;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Feature("Тесты на проверку текста")
public class TextTests extends BaseClass {

   @BeforeMethod
    public void beforeMethod(){
        Selenide.open(address.getAddress());

    }
    @Test(description = "Проверка текстовых элементов на главной странице")
    public void test() {
        $("h1").shouldHave(text("Bring projects, wikis, and teams together"));
        $("span.text-primary").shouldHave(text("with AI"));
        $x("//div[@class='desc']").shouldHave(text("The AI workspace where you achieve more without losing control of your data"));

    }
}

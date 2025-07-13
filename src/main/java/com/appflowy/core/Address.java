package com.appflowy.core;

import io.qameta.allure.Step;

public class Address {
    private final String address = "https://appflowy.com/";
    private final String[] navigationBarLinks = {"https://appflowy.com/download", "https://appflowy.com/download#ios-and-android", "https://appflowy.com/download#macOS", "https://appflowy.com/pricing"};
    private final String addressForRegistration = "https://appflowy.com/app";
    private final String apiStartAddress = "https://beta.appflowy.cloud";
    private final String apiAddressForTemplates = "/api/workspace/published-outline/5fca8c8a-8126-428e-bb5e-0efeef22ab56";
    private final String magicLink = "/gotrue/magiclink";
    private final String encodedRedirectUrl = "https%3A%2F%2Fappflowy.com%2Fapp";
    private final String redirectTo = "https://appflowy.com/login?redirectTo=";

    @Step("Получить главный адрес страницы")
    public String getAddress() {
        return address;
    }

    @Step("Получить ссылку навигации с индексом {index}")
    public String getNavigationBarLink(int index) {
        if (index >= 0 && index < navigationBarLinks.length) {
            return navigationBarLinks[index];
        } else {
            throw new IllegalArgumentException("Не валидный индекс: " + index);
        }
    }

    @Step("Получить адрес для регистрации")
    public String getRegistrationAddress(){
        return addressForRegistration;
    }

    @Step("Получить стартовый адрес для API")
    public String getApiStartAddress(){
        return apiStartAddress;
    }

    @Step("Получить адрес для Templates")
    public String getApiAddressForTemplates(){
        return apiAddressForTemplates;
    }

    @Step("Получить редирект")
    public String getEncodedRedirectUrl(){
        return  encodedRedirectUrl;
    }

    @Step("Получить magic Link")
    public String getMagicLink(){
        return  magicLink;
    }

    @Step("Получить редирект")
    public String getRedirectTo(){
        return  redirectTo;
    }
}

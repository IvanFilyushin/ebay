package com.ebay.autotests;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private static final String LOGIN = "//input[@name='userid']";
    private static final String PASSWORD = "//input[@name='pass']";
    private static final String DONE_LOGIN = "//input[@type='submit']";

    public void fillField(String fieldName, String value) {
        String field = "";
        switch (fieldName) {
            case "Логин":
                $(By.xpath(LOGIN)).sendKeys(value);
                break;
            case "Пароль":
                $(By.xpath(PASSWORD)).sendKeys(value);
                break;
        }
    }

    public MainPage pressEnterButton() {
        $(By.xpath(DONE_LOGIN)).click();
        return page(MainPage.class);
    }

}

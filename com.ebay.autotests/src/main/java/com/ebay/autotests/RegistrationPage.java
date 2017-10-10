package com.ebay.autotests;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    private static final String FIRST_NAME = "//input[@name='firstname']";
    private static final String LAST_NAME = "//input[@name='lastname']";
    private static final String EMAIL = "//input[@name='email']";
    private static final String PASSWORD = "//input[@name='PASSWORD']";
    private static final String DONE_REGISTRATION = "//input[@id='ppaFormSbtBtn']";


    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Имя":
                $(By.xpath(FIRST_NAME)).sendKeys(value);
                break;
            case "Фамилия":
                $(By.xpath(LAST_NAME)).sendKeys(value);
                break;
            case "Email":
                $(By.xpath(EMAIL)).sendKeys(value);
                break;
            case "Пароль":
                $(By.xpath(PASSWORD)).sendKeys(value);
                break;
        }
    }

    public MainPage pressRegButton() {
        $(By.xpath(DONE_REGISTRATION)).click();
        return page(MainPage.class);
    }
}

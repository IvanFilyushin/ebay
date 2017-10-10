package com.ebay.autotests;


import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static final String SEARCH_FIELD = "//input[@class='gh-tb ui-autocomplete-input']";
    private static final String SEARCH_BUTTON = "//input[@id = 'gh-btn']";
    private static final String NEXT_PAGE = "//a[@class = 'gspr next']";
    private static final String STATUS_ON = "//a[text() = 'Здравствуйте, ']";
    private static final String STATUS_OFF = "//a[text() = 'Войдите']";
    private static final String EXIT = "//a[text() = 'Выход']";


    public RegistrationPage registration() {
        $(By.xpath("//a[contains(text(),'зарегистрируйтесь')]")).click();
        return page(RegistrationPage.class);
    }

    public LoginPage login() {
        $(By.xpath("//a[contains(text(),'Войдите')]")).click();
        return page(LoginPage.class);
    }

    public void search(String text) {
        $(By.xpath(SEARCH_FIELD)).sendKeys(text);

    }

    public void pressButton(String buttonName) {
        switch (buttonName){
            case "Найти":
                $(By.xpath(SEARCH_BUTTON)).click();
                break;
            case "Следующая страница":
                $(By.xpath(NEXT_PAGE)).click();
                break;
        }
    }

    public void numberArticles(String expected) {
        Assert.assertEquals($$(By.xpath("//ul[@id='ListViewInner']/li")).size(), Integer.parseInt(expected));
    }

    public void logout(){
        $(By.xpath(STATUS_ON)).click();
        $(By.xpath(EXIT)).click();
    }

    public void isLogoutDone() {

        Assert.assertEquals($$(By.xpath(STATUS_OFF)).size(), 1);
    }
}


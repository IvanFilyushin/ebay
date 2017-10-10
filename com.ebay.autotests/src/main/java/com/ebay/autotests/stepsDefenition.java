package com.ebay.autotests;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Также;
import cucumber.api.java.ru.Тогда;

import static com.codeborne.selenide.Selenide.open;

public class stepsDefenition {

    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    protected static String email = "";

    @Дано("^открыта страница \"([^\"]*)\"$")
    public void mainPageIsOpened(String url) {
        mainPage = open(url, MainPage.class);
    }

    @Также("^пользователь выбрал ссылку регистрации$")
    public void toRegistrationPage() {
        registrationPage = mainPage.registration();
    }

    @Также("^пользователь заполняет регистрационное поле \"(.*?)\" значением \"(.*?)\"$")
    public void fillRegistrationField(String fieldName, String value)
    {
        registrationPage.fillField(fieldName, value);
    }

    @Также("^пользователь нажимает на кнопку зарегистрироваться$")
    public void finishRegistration() {
        mainPage = registrationPage.pressRegButton();
    }

    @Также("^пользователь заполняет поле \"(.*?)\" значением \"(.*?)\"$")
    public void fillLoginField(String fieldName, String value)
    {
        loginPage.fillField(fieldName, value);
    }

    @Также("^пользователь выбрал ссылку входа в магазин$")
    public void toLoginPage() {
        loginPage = mainPage.login();
    }


    @Также("^пользователь нажимает на кнопку входа в систему$")
    public void finishLogin() {
        mainPage = loginPage.pressEnterButton();
    }

    @Дано("^пользователь заполняет поле поиска товара значением \"(.*?)\"$")
    public void searchArticle(String text) {
        mainPage.search(text);
    }

    @Также("^пользователь нажимает на кнопку \"(.*?)\"$")
    public void pressButtonMainPage(String button) {
        mainPage.pressButton(button);
    }

    @Тогда("^на странице отображается \"(.*?)\" товаров$")
    public void numberFoundedArticles(String expected) {
        mainPage.numberArticles(expected);

    }

    @Тогда("^пользователь выполняет выход из учётной записи")
    public void logOut() {
        mainPage.logout();

    }

    @Тогда("^выход из учётной записи выполнен")
    public void checkLogout() {
        mainPage.isLogoutDone();

    }

}

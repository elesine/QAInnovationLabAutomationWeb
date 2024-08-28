package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPageStore {

    //Localizadores de elementos
    public static By emailInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By error = By.cssSelector(".alert.alert-danger");

}

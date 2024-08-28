package com.nttdata.steps;

import com.nttdata.page.LoginPageStore;
import org.openqa.selenium.WebDriver;


public class LoginStoreSteps {

    private WebDriver driver;

    //constructor
    public LoginStoreSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el email
     * @param email el email
     */
    public void typeEmail(String email){
        this.driver.findElement(LoginPageStore.emailInput).sendKeys(email);
    }
    /**
     * Escribir el password
     * @param password el password del usuario
     */

    public void typePassword(String password){

        this.driver.findElement(LoginPageStore.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){

        this.driver.findElement(LoginPageStore.loginButton).click();
    }

    public void validarLogeo() {
    }
}

package com.nttdata.steps;

import com.nttdata.page.LoginPageStore;
import com.nttdata.page.ProductoPageStore;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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

    public boolean validarLogeo() {

        try {
            // Esperar hasta que el enlace de "Sign out" sea visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement logout  =  wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageStore.logout));
            return logout.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("No se logeo correctamente.");
            return false; // El enlace no se encontró, por lo que es probable que el usuario no esté autenticado
        }
    }

}

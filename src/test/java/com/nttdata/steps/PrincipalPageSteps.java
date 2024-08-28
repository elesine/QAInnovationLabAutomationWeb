package com.nttdata.steps;

import com.nttdata.page.PrincipalPageStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;


public class PrincipalPageSteps {

    private WebDriver driver;

    //constructor
    public PrincipalPageSteps(WebDriver driver){
        this.driver = driver;
    }

    public void irPaginaLogin(){
        this.driver.findElement(PrincipalPageStore.loginLink).click();
    }

    public boolean seleccionoCategoria(String categoria) {
        List<WebElement> categorias = this.driver.findElements(PrincipalPageStore.listacategorias);
        WebElement link;
        for (WebElement categoriaItem : categorias) {
            if(Objects.equals(categoria, categoriaItem.getText())) {
                link = categoriaItem.findElement(PrincipalPageStore.categorias);
                link.click();
                return true;
            }
        }
        return false;
    }

}

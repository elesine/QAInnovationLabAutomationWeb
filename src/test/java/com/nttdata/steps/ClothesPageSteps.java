package com.nttdata.steps;

import com.nttdata.page.ClothesPageStore;
import com.nttdata.page.PrincipalPageStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;


public class ClothesPageSteps {

    private WebDriver driver;

    //constructor
    public ClothesPageSteps(WebDriver driver){
        this.driver = driver;
    }


    public boolean seleccionoSubCategoria(String subcategoria) {
        List<WebElement> subcategorias = this.driver.findElements(ClothesPageStore.listasubcategoria);
        WebElement link;

        for (WebElement subcategoriaItem : subcategorias) {
            System.out.print("result: "+ subcategoriaItem.getText()+"---"+ subcategoria + "\\n");

            if(Objects.equals(subcategoria, subcategoriaItem.getText())) {
                link = subcategoriaItem.findElement(ClothesPageStore.subcategoria);
                link.click();
                return true;
            }
        }
        return false;
    }

    public boolean seleccionPrimerArticulo() {
        List<WebElement> products = this.driver.findElements(ClothesPageStore.listaproductos);

        if (!products.isEmpty()) {
            WebElement firstProduct = products.get(0);
            WebElement firstProductLink = firstProduct.findElement(ClothesPageStore.producto);
            firstProductLink.click();

            System.out.println("Hiciste clic en el primer producto");
            return true;
        } else {
            System.out.println("No se encontraron productos");
            return false;
        }

    }
}

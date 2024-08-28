package com.nttdata.steps;

import com.nttdata.page.CarritoPageStore;
import com.nttdata.page.ProductoPageStore;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductoPageSteps {

    private WebDriver driver;

    //constructor
    public ProductoPageSteps(WebDriver driver){
        this.driver = driver;
    }

    public void agregarUnidades(int unidades) {
        WebElement quantityInput = driver.findElement(ProductoPageStore.cantidadInput);
        System.out.println("Productos cantidad "+quantityInput.getText());
        // Limpia el campo antes de establecer el nuevo valor
        quantityInput.clear();
        System.out.println("Productos cantidad limpio: " + quantityInput.getAttribute("value"));
        // Limpiar el campo usando JavaScript para asegurar que se borre completamente
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", quantityInput);

        quantityInput.sendKeys(String.valueOf(unidades));
        System.out.println("Productos cantidad agregado: " + quantityInput.getAttribute("value"));
    }

    public void agregarCarrito() {
        this.driver.findElement(ProductoPageStore.agregarCarritoButton).click();
    }

    public void proceedToCheckout() {
        //Espera Explicita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductoPageStore.proceedToCheckoutButton));
        //Modal
        WebElement proceedToCheckoutButton = driver.findElement(ProductoPageStore.proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }

    public boolean obtenerMensajeConfirmacion() {
        // Espera hasta que el modal con el título sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement modalTitulo =  wait.until(ExpectedConditions.visibilityOfElementLocated(ProductoPageStore.modalTitle));
        // Si se encontró el elemento y es visible, retorna true
        return modalTitulo.isDisplayed();
    }

    public boolean validacionMontoCorrecto() {

        WebElement quantity = driver.findElement(ProductoPageStore.productQuantity);

        float quantityFloat = Float.parseFloat(quantity.getText().replace("Quantity: ", "").trim());

        WebElement precio = driver.findElement(ProductoPageStore.productPrice);
        float precioFloat = Float.parseFloat(precio.getText().replace("PEN", ""));
        System.out.println("PRECIO"  + precio);
        System.out.println("PRECIO FLOAT"  + precioFloat);

        float totalvalidacion = quantityFloat * precioFloat;
        WebElement totalprecio = driver.findElement(ProductoPageStore.totalValue);
        float totalprecioFloat = Float.parseFloat(totalprecio.getText().replace("PEN", ""));
        if(totalvalidacion == totalprecioFloat )
            return true;
        else
            return false;
    }

    public boolean validoTituloCarrito() {
        // Espera hasta que el modal con el título sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement modalTitulo =  wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPageStore.tituloCarrito));
        // Si se encontró el elemento y es visible, retorna true
        return modalTitulo.isDisplayed();

    }
}

package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class ProductStoreStepsDef {

    private WebDriver driver;
    PrincipalPageSteps principalPageSteps = null;
    ClothesPageSteps clothesPageStepsSteps = null;
    ProductoPageSteps productoPageStepsSteps = null;


    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/en/");
        screenShot();
    }

    //@And("me logueo con mi usuario {string} y clave {string}")
    @And("me logueo con mi usuario {} y clave {}")
    public void meLogueoConMiUsuarioYClave(String email, String password) {
        //Voy a la pagina de logeo
        this.principalPageSteps = new PrincipalPageSteps(driver);
        this.principalPageSteps.irPaginaLogin();
        screenShot();
        //inicio el logeo
        LoginStoreSteps loginSteps = new LoginStoreSteps(driver);
        loginSteps.typeEmail(email);
        loginSteps.typePassword(password);
        loginSteps.login();
        //loginSteps.validarLogeo();
        screenShot();
    }

    //@When("navego a la categoria {string} y subcategoria {string}")
    @When("navego a la categoria {} y subcategoria {}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        //Categoria
        boolean isCategoriaSeleccionada = principalPageSteps.seleccionoCategoria(categoria);
        Assert.assertTrue("La categoría no existe", isCategoriaSeleccionada);
        screenShot();

        //Subcategoria
        clothesPageStepsSteps = new ClothesPageSteps(driver);
        boolean isSubCategoriaSeleccionada = clothesPageStepsSteps.seleccionoSubCategoria(subcategoria);
        Assert.assertTrue("La subcategoría no existe", isSubCategoriaSeleccionada);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        //Selecciono el primer producto
        boolean isPrimerArticuloSeleccionado = clothesPageStepsSteps.seleccionPrimerArticulo();
        Assert.assertTrue("No hay Articulos", isPrimerArticuloSeleccionado);
        screenShot();

        //Agregar unidades
        productoPageStepsSteps = new ProductoPageSteps(driver);
        productoPageStepsSteps.agregarUnidades(unidades);
        screenShot();

        //Agregar al carrito
        productoPageStepsSteps.agregarCarrito();
        screenShot();

    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        boolean confirmacion =productoPageStepsSteps.obtenerMensajeConfirmacion();
        Assert.assertTrue("No se ha confirmado el producto agregado", confirmacion);
        screenShot();

    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        boolean confirmacion =productoPageStepsSteps.validacionMontoCorrecto();
        Assert.assertTrue("El monto calculado no es correcto", confirmacion);
        screenShot();

    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        productoPageStepsSteps.proceedToCheckout();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        boolean hayTituloCarrito =productoPageStepsSteps.validoTituloCarrito();
        Assert.assertTrue("No hay el titulo de la pagina del carrito. ", hayTituloCarrito);
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }


}

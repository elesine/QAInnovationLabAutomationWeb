package com.nttdata.page;

import org.openqa.selenium.By;

public class ClothesPageStore {
    //Localizadores de elementos
    public static By listasubcategoria = By.cssSelector("ul.subcategories-list > li");
    public static By subcategoria = By.cssSelector("a.subcategory-name");

    public static By listaproductos = By.cssSelector("div.js-product");
    public static By producto = By.cssSelector("a.product-thumbnail");

}

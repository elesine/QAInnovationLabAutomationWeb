package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductoPageStore {

    public static By cantidadInput = By.cssSelector("input#quantity_wanted");
    public static By agregarCarritoButton = By.cssSelector("button.btn.btn-primary.add-to-cart");
    public static By modalTitle = By.xpath("//h4[@class='modal-title h6 text-sm-center' and contains(text(), 'Product successfully added to your shopping cart')]");
    public static By productPrice = By.cssSelector("div.col-md-5.divide-right .col-md-6:nth-of-type(2) .product-price");
    public static By productQuantity = By.cssSelector("div.col-md-5.divide-right .col-md-6:nth-of-type(2) .product-quantity");
    public static By totalValue = By.cssSelector("div.col-md-7 .cart-content .product-total .value");
    public static By proceedToCheckoutButton = By.cssSelector("div.cart-content-btn a.btn.btn-primary");

}

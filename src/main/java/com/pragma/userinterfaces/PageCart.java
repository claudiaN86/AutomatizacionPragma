package com.pragma.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PageCart {
    public static final Target LABEL_NAME_PRODUCT_CART = Target.the("Label del nombre del producto del carrito").locatedBy("//td[text()='{0}']");
    public static final Target BUTTON_DELETE = Target.the("Botón de deliminar productos del carrito").locatedBy("//a[text()='Delete']");

}

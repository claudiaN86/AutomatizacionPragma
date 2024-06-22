package com.pragma.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PageCart {
    public static final Target LABEL_NAME_PRODUCT_CART = Target.the("Label del nombre del producto del carrito").locatedBy("//td[text()='{0}']");

}

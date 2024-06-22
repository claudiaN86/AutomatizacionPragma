package com.pragma.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.pragma.userinterfaces.PageCart.LABEL_NAME_PRODUCT_CART;

public class ValidateNameProducts implements Question<Boolean> {
    private String product;

    public ValidateNameProducts(String product) {
        this.product = product;
    }

    public static ValidateNameProducts verify(String product) {
        return new ValidateNameProducts(product);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LABEL_NAME_PRODUCT_CART.of(product).isVisibleFor(actor);
    }
}

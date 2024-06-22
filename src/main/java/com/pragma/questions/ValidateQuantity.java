package com.pragma.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.pragma.userinterfaces.PageCart.LABEL_NAME_PRODUCT_CART;

public class ValidateQuantity implements Question<Boolean> {

    private String product;
    private Integer quantity;

    public ValidateQuantity(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public static ValidateQuantity verify(String product, Integer quantity) {
        return new ValidateQuantity(product, quantity);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LABEL_NAME_PRODUCT_CART.of(product), WebElementStateMatchers.isVisible())
        );
        int quantityProducts = LABEL_NAME_PRODUCT_CART.of(product).resolveAllFor(actor).size();
        return quantity == quantityProducts;
    }
}

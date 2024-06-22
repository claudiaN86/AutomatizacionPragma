package com.pragma.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.pragma.userinterfaces.PageCart.LABEL_PRICE_PRODUCT_CART;

public class ValidatePriceProduct implements Question<Boolean> {

    private String price;
    private String product;

    public ValidatePriceProduct(String price, String product) {
        this.price = price;
        this.product = product;
    }

    public static ValidatePriceProduct verify(String price, String product) {
        return new ValidatePriceProduct(price, product);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LABEL_PRICE_PRODUCT_CART.of(product), WebElementStateMatchers.isVisible())
        );
        String priceProducts = LABEL_PRICE_PRODUCT_CART.of(product).resolveFor(actor).getText();
        return price.equals(priceProducts);
    }
}

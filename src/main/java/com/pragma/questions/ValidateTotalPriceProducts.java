package com.pragma.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static com.pragma.userinterfaces.PageCart.LABEL_PRICE_PRODUCT_CART;
import static com.pragma.userinterfaces.PageCart.LABEL_TOTAL_PRICE_PRODUCT_CART;

public class ValidateTotalPriceProducts implements Question<Boolean> {
    private List<Map<String, String>> products;

    public ValidateTotalPriceProducts(List<Map<String, String>> products) {
        this.products = products;
    }

    public static ValidateTotalPriceProducts verify(List<Map<String, String>> products) {
        return new ValidateTotalPriceProducts(products);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        int sumTotal = 0;
        for (Map<String, String> product : products) {
            sumTotal += Integer.parseInt(LABEL_PRICE_PRODUCT_CART.of(product.get("product")).resolveFor(actor).getText());
        }
        int actual = Integer.parseInt(LABEL_TOTAL_PRICE_PRODUCT_CART.resolveFor(actor).getText());
        return sumTotal == actual;
    }
}
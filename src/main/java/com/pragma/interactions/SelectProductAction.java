package com.pragma.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

import static com.pragma.userinterfaces.HomePage.LABEL_NAME_PRODUCT;

public class SelectProductAction implements Interaction {
    private String productName;

    public SelectProductAction(String productName) {
        this.productName = productName;
    }

    public static Performable withTheData(String productName) {
        return Tasks.instrumented(SelectProductAction.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade productOption = null;
        List<WebElementFacade> products = LABEL_NAME_PRODUCT.resolveAllFor(actor);
        for (WebElementFacade product : products) {
            if (product.getText().equals(productName)) {
                productOption = product;

            }
        }
        productOption.click();
    }
}

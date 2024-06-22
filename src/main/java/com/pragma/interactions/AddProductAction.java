package com.pragma.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;

import static com.pragma.userinterfaces.PageProduct.BUTTON_ADD_TO_CART;

public class AddProductAction implements Interaction {

    private int productQuantity;

    public AddProductAction(int productQuantity) {
        this.productQuantity = productQuantity;

    }

    public static Performable withTheData(int productQuantity) {
        return Tasks.instrumented(AddProductAction.class, productQuantity);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (int x = 0; x < productQuantity; x++) {
            actor.attemptsTo(
                    Click.on(BUTTON_ADD_TO_CART),
                    WaitUntilAction.on(),
                    Switch.toAlert().andAccept()
            );
        }
    }
}

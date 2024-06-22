package com.pragma.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.pragma.userinterfaces.PageCart.BUTTON_DELETE;

public class DeleteProductAction implements Interaction {

    public static Performable withTheData() {
        return Tasks.instrumented(DeleteProductAction.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        while (BUTTON_DELETE.isVisibleFor(actor)) {
            actor.attemptsTo(
                    WaitUntil.the(BUTTON_DELETE, WebElementStateMatchers.isPresent()),
                    Click.on(BUTTON_DELETE)
            );
        }
    }
}

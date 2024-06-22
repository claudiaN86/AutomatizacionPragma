package com.pragma.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

public class WaitUntilAction implements Interaction {

    public static Performable on() {
        return Tasks.instrumented(WaitUntilAction.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

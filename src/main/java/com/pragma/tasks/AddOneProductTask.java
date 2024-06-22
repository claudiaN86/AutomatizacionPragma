package com.pragma.tasks;

import com.pragma.interactions.SelectProductAction;
import com.pragma.interactions.WaitUntilAction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.pragma.userinterfaces.HomePage.BUTTON_ACCESS_CART;
import static com.pragma.userinterfaces.PageProduct.BUTTON_ADD_TO_CART;

public class AddOneProductTask implements Task {

    private String productName;

    public AddOneProductTask(String productName) {
        this.productName = productName;
    }

    public static Performable withData(String nameProduct) {
        return Tasks.instrumented(AddOneProductTask.class, nameProduct);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectProductAction.withTheData(productName),
                Click.on(BUTTON_ADD_TO_CART),
                WaitUntilAction.on(),
                Switch.toAlert().andAccept(),
                Click.on(BUTTON_ACCESS_CART)
        );
    }
}

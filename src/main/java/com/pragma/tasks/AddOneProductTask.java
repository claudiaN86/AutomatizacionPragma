package com.pragma.tasks;

import com.pragma.interactions.AddProductAction;
import com.pragma.interactions.SelectProductAction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.pragma.userinterfaces.HomePage.BUTTON_ACCESS_CART;

public class AddOneProductTask implements Task {

    private String productName;
    private Integer quantity;

    public AddOneProductTask(String productName, Integer quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public static Performable withData(String productName, Integer quantity) {
        return Tasks.instrumented(AddOneProductTask.class, productName, quantity);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectProductAction.withTheData(productName),
                AddProductAction.withTheData(quantity),
                Click.on(BUTTON_ACCESS_CART)
        );
    }
}

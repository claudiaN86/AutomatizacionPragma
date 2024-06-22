package com.pragma.tasks;

import com.pragma.interactions.AddProductAction;
import com.pragma.interactions.SelectProductAction;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;

import static com.pragma.userinterfaces.HomePage.BUTTON_ACCESS_CART;
import static com.pragma.userinterfaces.HomePage.BUTTON_HOME;

public class AddingMultipleProducts implements Task {

    private List<Map<String, String>> products;


    public AddingMultipleProducts(List<Map<String, String>> products) {
        this.products = products;

    }

    public static Performable withData(List<Map<String, String>> products) {
        return Tasks.instrumented(AddingMultipleProducts.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("listTable", products);
        for (Map<String, String> product : products) {
            String productName = product.get("product");
            int quantity = Integer.parseInt(product.get("quantity"));
            actor.attemptsTo(
                    SelectProductAction.withTheData(productName),
                    AddProductAction.withTheData(quantity),
                    Click.on(BUTTON_HOME)
            );
        }
        actor.attemptsTo(
                Click.on(BUTTON_ACCESS_CART)
        );
    }
}

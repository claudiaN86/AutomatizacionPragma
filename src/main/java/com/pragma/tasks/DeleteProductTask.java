package com.pragma.tasks;

import com.pragma.interactions.DeleteProductAction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class DeleteProductTask implements Task {

    public static Performable withData() {
        return Tasks.instrumented(DeleteProductTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DeleteProductAction.withTheData()
        );
    }
}

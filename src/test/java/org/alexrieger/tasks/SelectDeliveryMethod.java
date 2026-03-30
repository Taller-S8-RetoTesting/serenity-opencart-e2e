package org.alexrieger.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.alexrieger.ui.CheckoutPageUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectDeliveryMethod implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.DELIVERY_METHOD_CONTINUE_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPageUI.DELIVERY_METHOD_CONTINUE_BUTTON)
        );
    }

    public static SelectDeliveryMethod withDefaults() {
        return Tasks.instrumented(SelectDeliveryMethod.class);
    }
}

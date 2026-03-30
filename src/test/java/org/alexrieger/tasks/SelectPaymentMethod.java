package org.alexrieger.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.alexrieger.ui.CheckoutPageUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectPaymentMethod implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.PAYMENT_TERMS_CHECKBOX, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPageUI.PAYMENT_TERMS_CHECKBOX),
                Click.on(CheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON)
        );
    }

    public static SelectPaymentMethod withDefaults() {
        return Tasks.instrumented(SelectPaymentMethod.class);
    }
}

package org.alexrieger.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.alexrieger.ui.CheckoutPageUI;
import org.alexrieger.ui.OrderSuccessPageUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmOrder implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.CONFIRM_ORDER_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPageUI.CONFIRM_ORDER_BUTTON),
                WaitUntil.the(OrderSuccessPageUI.SUCCESS_HEADING, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static ConfirmOrder now() {
        return Tasks.instrumented(ConfirmOrder.class);
    }
}
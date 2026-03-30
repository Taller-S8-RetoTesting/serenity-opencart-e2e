package org.alexrieger.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.alexrieger.ui.CheckoutPageUI;
import org.alexrieger.ui.ShoppingCartPageUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BeginGuestCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ShoppingCartPageUI.CHECKOUT_BUTTON),
                WaitUntil.the(CheckoutPageUI.GUEST_CHECKOUT_RADIO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPageUI.GUEST_CHECKOUT_RADIO),
                Click.on(CheckoutPageUI.ACCOUNT_CONTINUE_BUTTON)
        );
    }

    public static BeginGuestCheckout now() {
        return Tasks.instrumented(BeginGuestCheckout.class);
    }
}

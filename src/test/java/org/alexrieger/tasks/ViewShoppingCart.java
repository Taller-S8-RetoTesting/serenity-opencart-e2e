package org.alexrieger.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.alexrieger.ui.HomePageUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ViewShoppingCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageUI.CART_DROPDOWN_BUTTON),
                WaitUntil.the(HomePageUI.VIEW_CART_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePageUI.VIEW_CART_LINK)
        );
    }

    public static ViewShoppingCart fromHeader() {
        return Tasks.instrumented(ViewShoppingCart.class);
    }
}
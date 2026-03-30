package org.alexrieger.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.alexrieger.ui.HomePageUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddFeaturedProductToCart implements Task {

    private final String productName;

    public AddFeaturedProductToCart(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageUI.ADD_TO_CART_BUTTON.of(productName)),
                WaitUntil.the(HomePageUI.SUCCESS_ALERT, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static AddFeaturedProductToCart called(String productName) {
        return Tasks.instrumented(AddFeaturedProductToCart.class, productName);
    }
}
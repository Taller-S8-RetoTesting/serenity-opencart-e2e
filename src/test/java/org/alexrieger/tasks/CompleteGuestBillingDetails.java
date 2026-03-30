package org.alexrieger.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.alexrieger.ui.CheckoutPageUI;
import org.alexrieger.util.TestData;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteGuestBillingDetails implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.BILLING_FIRST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(TestData.FIRST_NAME).into(CheckoutPageUI.BILLING_FIRST_NAME),
                Enter.theValue(TestData.LAST_NAME).into(CheckoutPageUI.BILLING_LAST_NAME),
                Enter.theValue(TestData.guestEmail()).into(CheckoutPageUI.BILLING_EMAIL),
                Enter.theValue(TestData.TELEPHONE).into(CheckoutPageUI.BILLING_TELEPHONE),
                Enter.theValue(TestData.ADDRESS_1).into(CheckoutPageUI.BILLING_ADDRESS_1),
                Enter.theValue(TestData.CITY).into(CheckoutPageUI.BILLING_CITY),
                Enter.theValue(TestData.POST_CODE).into(CheckoutPageUI.BILLING_POST_CODE),
                SelectFromOptions.byVisibleText(TestData.COUNTRY).from(CheckoutPageUI.BILLING_COUNTRY),
                WaitUntil.the(CheckoutPageUI.BILLING_REGION, isClickable()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(TestData.REGION).from(CheckoutPageUI.BILLING_REGION),
                Click.on(CheckoutPageUI.BILLING_CONTINUE_BUTTON)
        );
    }

    public static CompleteGuestBillingDetails withDefaultData() {
        return Tasks.instrumented(CompleteGuestBillingDetails.class);
    }
}

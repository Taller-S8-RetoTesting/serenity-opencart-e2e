package org.alexrieger.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import org.alexrieger.hooks.OpenBrowser;
import org.alexrieger.questions.OrderSuccessMessage;
import org.alexrieger.tasks.AddFeaturedProductToCart;
import org.alexrieger.tasks.BeginGuestCheckout;
import org.alexrieger.tasks.CompleteGuestBillingDetails;
import org.alexrieger.tasks.ConfirmOrder;
import org.alexrieger.tasks.SelectDeliveryMethod;
import org.alexrieger.tasks.SelectPaymentMethod;
import org.alexrieger.tasks.ViewShoppingCart;
import org.alexrieger.util.TestData;

import static org.assertj.core.api.Assertions.assertThat;

public class GuestCheckoutStepDefinition {

    @Given("the user is on the OpenCart store home page")
    public void theUserIsOnTheOpenCartStoreHomePage() {
        Actor actor = OnStage.theActorCalled(TestData.ACTOR_NAME);
        actor.attemptsTo(OpenBrowser.withUrl(TestData.BASE_URL));
    }

    @When("the user adds {string} to the cart")
    public void theUserAddsProductToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddFeaturedProductToCart.called(productName)
        );
    }

    @And("the user views the shopping cart")
    public void theUserViewsTheShoppingCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ViewShoppingCart.fromHeader()
        );
    }

    @And("the user proceeds to checkout as guest")
    public void theUserProceedsToCheckoutAsGuest() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BeginGuestCheckout.now()
        );
    }

    @And("the user fills in the billing details as a guest")
    public void theUserFillsInTheBillingDetailsAsAGuest() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteGuestBillingDetails.withDefaultData()
        );
    }

    @And("the user selects the delivery method")
    public void theUserSelectsTheDeliveryMethod() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectDeliveryMethod.withDefaults()
        );
    }

    @And("the user selects the payment method")
    public void theUserSelectsThePaymentMethod() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectPaymentMethod.withDefaults()
        );
    }

    @And("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmOrder.now()
        );
    }

    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String expectedMessage) {
        Actor actor = OnStage.theActorInTheSpotlight();
        String actualMessage = actor.asksFor(OrderSuccessMessage.displayed());
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
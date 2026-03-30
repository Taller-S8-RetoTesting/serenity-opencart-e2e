package org.alexrieger.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPageUI {

    public static final Target GUEST_CHECKOUT_RADIO = Target.the("guest checkout radio button")
            .located(By.cssSelector("input[name='account'][value='guest']"));

    public static final Target ACCOUNT_CONTINUE_BUTTON = Target.the("account continue button")
            .located(By.cssSelector("#button-account"));

    public static final Target BILLING_FIRST_NAME = Target.the("billing first name field")
            .located(By.cssSelector("#input-payment-firstname"));

    public static final Target BILLING_LAST_NAME = Target.the("billing last name field")
            .located(By.cssSelector("#input-payment-lastname"));

    public static final Target BILLING_EMAIL = Target.the("billing email field")
            .located(By.cssSelector("#input-payment-email"));

    public static final Target BILLING_TELEPHONE = Target.the("billing telephone field")
            .located(By.cssSelector("#input-payment-telephone"));

    public static final Target BILLING_ADDRESS_1 = Target.the("billing address line 1 field")
            .located(By.cssSelector("#input-payment-address-1"));

    public static final Target BILLING_CITY = Target.the("billing city field")
            .located(By.cssSelector("#input-payment-city"));

    public static final Target BILLING_POST_CODE = Target.the("billing post code field")
            .located(By.cssSelector("#input-payment-postcode"));

    public static final Target BILLING_COUNTRY = Target.the("billing country select")
            .located(By.cssSelector("select#input-payment-country"));

    public static final Target BILLING_REGION = Target.the("billing region select")
            .located(By.cssSelector("select#input-payment-zone"));

    public static final Target BILLING_CONTINUE_BUTTON = Target.the("billing continue button")
            .located(By.cssSelector("#button-guest"));

    public static final Target DELIVERY_METHOD_CONTINUE_BUTTON = Target.the("delivery method continue button")
            .located(By.cssSelector("#button-shipping-method"));

    public static final Target PAYMENT_TERMS_CHECKBOX = Target.the("payment terms checkbox")
            .located(By.cssSelector("input[name='agree']"));

    public static final Target PAYMENT_METHOD_CONTINUE_BUTTON = Target.the("payment method continue button")
            .located(By.cssSelector("#button-payment-method"));

    public static final Target CONFIRM_ORDER_BUTTON = Target.the("confirm order button")
            .located(By.cssSelector("#button-confirm"));
}

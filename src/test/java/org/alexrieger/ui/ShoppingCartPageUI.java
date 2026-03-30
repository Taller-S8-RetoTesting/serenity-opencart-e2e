package org.alexrieger.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCartPageUI {

    public static final Target CHECKOUT_BUTTON = Target.the("checkout button on shopping cart page")
            .located(By.xpath("//a[contains(@href,'route=checkout/checkout')]"));
}

package org.alexrieger.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI {

    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button for product {0}")
            .locatedBy("//div[@id='content']//h4/a[normalize-space()='{0}']/ancestor::div[contains(@class,'product-thumb')]//button[contains(@onclick,'cart.add')]");

    public static final Target SUCCESS_ALERT = Target.the("success alert message")
            .located(By.cssSelector(".alert.alert-success"));

    public static final Target CART_DROPDOWN_BUTTON = Target.the("cart dropdown button")
            .located(By.cssSelector("#cart > button"));

    public static final Target VIEW_CART_LINK = Target.the("view cart link in cart dropdown")
            .located(By.xpath("//a[normalize-space()='View Cart']"));
}

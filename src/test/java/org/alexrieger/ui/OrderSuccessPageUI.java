package org.alexrieger.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class OrderSuccessPageUI {

    public static final Target SUCCESS_HEADING = Target.the("order success heading")
            .located(By.xpath("//div[@id='content']/h1[contains(text(),'Your order has been placed')]"));
}

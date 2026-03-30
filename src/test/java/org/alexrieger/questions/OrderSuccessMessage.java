package org.alexrieger.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.alexrieger.ui.OrderSuccessPageUI;

public class OrderSuccessMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(OrderSuccessPageUI.SUCCESS_HEADING)
                .answeredBy(actor)
                .trim();
    }

    public static Question<String> displayed() {
        return new OrderSuccessMessage();
    }
}

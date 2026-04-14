package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class VerificarResumen implements Task {
    private final String totalEsperado;

    public VerificarResumen(String totalEsperado) {
        this.totalEsperado = totalEsperado;
    }

    public static VerificarResumen total(String totalEsperado) {
        return new VerificarResumen(totalEsperado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat("El total de los items",
                        Text.of(Target.the("Subtotal").locatedBy(CheckoutPage.ITEM_TOTAL)),
                        containsString(totalEsperado))
        );
    }
}
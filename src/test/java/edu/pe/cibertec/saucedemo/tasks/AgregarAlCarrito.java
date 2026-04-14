package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class AgregarAlCarrito implements Task {
    private final String productName;

    public AgregarAlCarrito(String productName) {
        this.productName = productName;
    }

    public static AgregarAlCarrito elProducto(String productName) {
        return new AgregarAlCarrito(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CarritoPage.botonAgregar(productName))
        );
    }

}

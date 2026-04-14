package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {

    @When("she adds the product {string} to the cart")
    public void sheAddsTheProductToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(productName)
        );
    }

    @When("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.elProducto(productName)
        );
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String quantity) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El contador del carrito",
                        Text.of(Target.the("Cart badge").locatedBy(CarritoPage.CART_BADGE)),
                        equalTo(quantity))
        );
    }

    @Then("the cart should contain {string} and {string}")
    public void theCartShouldContainAnd(String product1, String product2) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Cart Link").locatedBy(CarritoPage.CART_LINK))
        );

        // Usamos la sintaxis de Playwright ">> nth=0" para seleccionar el primer y segundo elemento
        OnStage.theActorInTheSpotlight().should(
                seeThat("Primer producto",
                        Text.of(Target.the("Primer item").locatedBy(CarritoPage.CART_ITEM_NAME + " >> nth=0")),
                        equalTo(product1)),
                seeThat("Segundo producto",
                        Text.of(Target.the("Segundo item").locatedBy(CarritoPage.CART_ITEM_NAME + " >> nth=1")),
                        equalTo(product2))
        );
    }

    @Then("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Cart Link").locatedBy(CarritoPage.CART_LINK))
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat("Único producto restante",
                        Text.of(Target.the("Item restante").locatedBy(CarritoPage.CART_ITEM_NAME)),
                        equalTo(product))
        );
    }
}
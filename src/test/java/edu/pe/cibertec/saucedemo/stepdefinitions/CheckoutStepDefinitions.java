package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.CompletarCheckout;
import edu.pe.cibertec.saucedemo.tasks.VerificarResumen;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutStepDefinitions {

    @When("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckout(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarCheckout.conDatos(firstName, lastName, postalCode)
        );
    }

    @When("she verifies the order summary shows item total {string}")
    public void sheVerifiesTheOrderSummary(String itemTotal) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarResumen.total(itemTotal)
        );
    }

    @When("she completes the order")
    public void sheCompletesTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Boton Finish").locatedBy(CheckoutPage.BOTON_FINISH))
        );
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeTheConfirmationMessage(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Mensaje de confirmacion",
                        Text.of(Target.the("Header completado").locatedBy(CheckoutPage.CONFIRMATION_MESSAGE)),
                        equalTo(message))
        );
    }

    @Then("the checkout form should remain visible")
    public void theCheckoutFormShouldRemainVisible() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Formulario de checkout",
                        Visibility.of(Target.the("Contenedor checkout").locatedBy(CheckoutPage.CHECKOUT_INFO_CONTAINER)),
                        equalTo(true))
        );
    }
}
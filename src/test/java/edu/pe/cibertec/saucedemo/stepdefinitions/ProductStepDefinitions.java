package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheProductDetail;
import edu.pe.cibertec.saucedemo.questions.TheProductPrice;
import edu.pe.cibertec.saucedemo.tasks.ClickOnProduct;
import edu.pe.cibertec.saucedemo.tasks.SortProducts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ProductStepDefinitions {

    @And("she sorts the products by {string}")
    public void sheSortsTheProductsBy(String sortOption) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SortProducts.by(sortOption)
        );
    }

    @Then("the first product should have price {string}")
    public void theFirstProductShouldHavePrice(String price) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductPrice.ofFirstItem(), equalTo(price))
        );
    }

    @And("the last product should have price {string}")
    public void theLastProductShouldHavePrice(String price) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductPrice.ofLasItem(), equalTo(price))
        );
    }

    @And("she clicks on the product {string}")
    public void sheClicksOnTheProduct(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickOnProduct.named(productName)
        );
    }

    @Then("she should see the product name {string}")
    public void sheShouldSeeTheProductName(String productName) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductDetail.name(), equalTo(productName))
        );
    }

    @And("she should see the product price {string}")
    public void sheShouldSeeTheProductPrice(String productPrice) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductDetail.price(), equalTo(productPrice))
        );
    }

    @And("she should see the Add to cart button")
    public void heShouldSeeTheAddToCartButton() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductDetail.addToCartButtonIsVisible(), is(true))
        );
    }

}

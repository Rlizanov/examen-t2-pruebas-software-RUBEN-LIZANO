package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.ProductDetailPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class TheProductDetail {
    public static Question<String> name() {
        return Text.of(Target.the("Product name")
                .locatedBy(ProductDetailPage.PRODUCT_NAME));
    }
    public static Question<String> price() {
        return Text.of(Target.the("Product price")
                .locatedBy(ProductDetailPage.PRODUCT_PRICE));
    }

    public static Question<Boolean> addToCartButtonIsVisible() {
        return Visibility.of(Target.the("Add to cart button")
                .locatedBy(ProductDetailPage.ADD_TO_CART_BUTTON));
    }
}

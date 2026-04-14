package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class ClickOnProduct {

    public static Performable named(String productName) {
        return Task.where("{0} click on product '" + productName + "'",
                Click.on(Target.the("Product " + productName)
                        .locatedBy(InventoryPage.itemNameLink(productName))));
    }

}

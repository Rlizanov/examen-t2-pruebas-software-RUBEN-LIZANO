package edu.pe.cibertec.saucedemo.tasks;

import com.microsoft.playwright.Page;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificarSesion implements Task {

    public static VerificarSesion activa() {
        return new VerificarSesion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        Page page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();

        assertThat(page.locator(InventoryPage.PAGE_TITLE)).isVisible();
        assertThat(page.locator(InventoryPage.PAGE_TITLE)).containsText("Products");
    }
}
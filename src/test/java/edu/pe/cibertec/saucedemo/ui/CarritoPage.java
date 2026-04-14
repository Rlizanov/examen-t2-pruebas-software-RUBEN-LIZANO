package edu.pe.cibertec.saucedemo.ui;

public class CarritoPage {
    public static final String CART_BADGE = ".shopping_cart_badge";
    public static final String CART_ITEM_NAME = ".inventory_item_name";
    public static final String CART_LINK = ".shopping_cart_link";

    public static String botonAgregar(String productName) {
        return "[data-test='add-to-cart-" + productName.toLowerCase().replace(" ", "-") + "']";
    }

    public static String botonRemover(String productName) {
        return "[data-test='remove-" + productName.toLowerCase().replace(" ", "-") + "']";
    }
}

package com.sazuluaga.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {
    public  static final Target ADD_TO_CART_BUTTON  = Target.the("add to cart button").locatedBy("//*[@id=\"tbodyid\"]//*[contains(text(),'Add to cart')]");
}

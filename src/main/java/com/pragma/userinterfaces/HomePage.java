package com.pragma.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("page:webdriver.base.url")
public class HomePage extends PageObject {

    public static final Target LABEL_NAME_PRODUCT = Target.the("Label del nombre del producto").locatedBy("//a[@class='hrefch']");
    public static final Target BUTTON_ACCESS_CART = Target.the("Botón de menú del carrito").located(By.id("cartur"));
    public static final Target BUTTON_HOME = Target.the("Botón de menú del Home").locatedBy("//a[text()='Home ']");

}

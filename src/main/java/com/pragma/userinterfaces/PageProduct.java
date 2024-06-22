package com.pragma.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageProduct {
    public static final Target BUTTON_ADD_TO_CART= Target.the("Botón de adicionar al carrito").locatedBy("//a[@class='btn btn-success btn-lg']");

}

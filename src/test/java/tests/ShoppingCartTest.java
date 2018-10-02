package tests;
;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.ShoppingCart;


import static helpers.Driver.getDriver;

public class ShoppingCartTest {

    private WebDriver driver;
    private static ShoppingCart shoppingCart;

    public ShoppingCartTest() {
        driver = getDriver();
        shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        shoppingCart.setDriver(driver);
    }




}

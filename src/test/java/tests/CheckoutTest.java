package tests;


import helpers.TestListener;
import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.Search;

import static helpers.Driver.getDriver;

@Epic("Checkout Test")
@Listeners({TestListener.class})

public class CheckoutTest {

    private WebDriver driver;
    private static CheckoutPage checkoutPage;

    public CheckoutTest() throws Exception {
        super();
        driver = getDriver();
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        checkoutPage.setDriver(driver);
    }


    @Test(description = "Validate checkout process for guest user", priority = 1)
    public static void validateCheckOutProcessForGuesUser() {
        checkoutPage.openHomePage();
        checkoutPage.addToCartFirstItemOnFeatureSlice();
        checkoutPage.navigateToCheckoutPage();
        checkoutPage.clickContinueButtonAsGuest();
        checkoutPage.fillCorrectBillingDetails();
        checkoutPage.acceptToTermsAndConditions();
        checkoutPage.clickConfirmOrder();


    }

}



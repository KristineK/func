package tests;

import helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;

import static helpers.Driver.getDriver;

@Feature("Product Test")
@Listeners({TestListener.class})
public class ProductTest {

    private WebDriver driver;
    private static ProductPage productPage;
    private static CheckoutPage checkoutPage;

    public ProductTest() {
        driver = getDriver();
        productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.setDriver(driver);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        checkoutPage.setDriver(driver);
    }

    @Test(description = "User can write a review", priority = 1)
    @Description("Test Description: User can write a review.")
    public static void testReviewCreation() throws Exception {
        checkoutPage.openHomePage();
        checkoutPage.addToCartFirstItemOnFeatureSlice();
        checkoutPage.navigateToCheckoutPage();
        checkoutPage.clickContinueButtonAsGuest();
        checkoutPage.fillCorrectBillingDetails();
        checkoutPage.acceptToTermsAndConditions();
        checkoutPage.clickConfirmOrder();

        productPage.openProductPage("BakBook");
        productPage.writeReviewForProduct("Admin", "12345 12345 12345 12345 12345", 2);
        productPage.checkSuccessReviewMessage();
    }

    @Test(description = "User can add product for comparison", priority = 1)
    @Description("Test Description: User can add product for comparison.")
    public static void userCanAddProductForComparison() throws Exception {
        String productName = "BakBook";
        productPage.openProductPage(productName);
        productPage.clickOnCompare();
        productPage.checkSuccessComparisonMessage(productName);
    }

    @Test(description = "User can see product data", priority = 1)
    @Description("Test Description: User can see product name, image and specification.")
    public static void userCanSeeProductData() throws Exception {
        String productName = "BakBook";
        productPage.openProductPage(productName);
        productPage.userCanSeeProductNamePriceImageAndSpecification(productName, "500.00");
    }
}

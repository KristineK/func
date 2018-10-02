package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.ProductPage;

import static helpers.Driver.getDriver;

public class ProductTest {

    private WebDriver driver;
    private static ProductPage productPage;

    public ProductTest() {
        driver = getDriver();
        productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.setDriver(driver);
    }

    @Test(description = "Validate search bar works from homepage", priority = 1)
    @Description("Test Description: Search bar should be displayed at homepage and work properly.")
    public static void testSearchBarHomepage() throws Exception {
        productPage.openProductPage("BakBook");
        productPage.addProductToTheCard();
    }
}

package tests;

import helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.Search;

import static helpers.Driver.getDriver;

@Epic("Searching Test")
@Listeners({TestListener.class})

public class SearchTest {

    private WebDriver driver;
    private static Search search;

    public SearchTest() throws Exception {
        super();
        driver = getDriver();
        search = PageFactory.initElements(driver, Search.class);
        search.setDriver(driver);
    }

    @Test(description = "Validate search bar is displayed", priority = 1)
    @Description("Test Description: Search bar should be displayed at homepage")
    public static void testSearchBarHomepage() throws Exception {
        search.openHomePage();
        search.validateSearchBarIsDisplayed();

    }

    @Test(description = "Validate short searching", priority = 1)
    @Description("Test Description: When searching for short strings f.e. Phone, then all products which contains this String in their name should be returned")
    public static void testSearchForIphFromPCsection() throws Exception {
        search.openHomePage();
        search.navigateTo("/index.php?route=product/category&path=20_26");
        search.validateSearchBarIsDisplayed();
        search.searchInformation("Phone");
        search.validateSearchResults("Phone");
    }

    @Test(description = "Validate product description search", priority = 1)
    @Description("Test Description: Product description should be searchable and with correct products returned")
    public static void testSearchDescription() throws Exception {
        search.openHomePage();
        search.navigateTo("/index.php?route=product/category&path=18_46");
        search.validateSearchBarIsDisplayed();
        search.searchInformation("Lorem ipsum is a pseudo-Latin");
        search.clickCheckBoxToSearchProductDescriptions();
        search.searchInformationInCriteriaSection("Lorem ipsum is a pseudo-Latin");
        search.productDescriptionContainsSearchedString("Lorem ipsum is a pseudo-Latin");

    }

}

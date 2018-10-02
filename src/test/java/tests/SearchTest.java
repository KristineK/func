package tests;

import helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.Search;

import static helpers.Driver.getDriver;

@Epic("Searching")
@Feature("Feature 1")
@Listeners({ TestListener.class })

public class SearchTest {

    private WebDriver driver;
    private static Search search;

    public SearchTest() throws Exception {
        super();
        driver = getDriver();
        search = PageFactory.initElements(driver, Search.class);
        search.setDriver(driver);
    }

    @Test(description = "Validate search bar works from homepage", priority = 1)
    @Description("Test Description: Search bar should be displayed at homepage and work properly.")
    public static void testSearchBarHomepage() throws Exception {
        search.openHomePage();
        search.validateSearchBarIsDisplayed();

    }

    @Test(description = "Validate search bar works from PC section", priority = 1)
    @Description("Test Description: Search bar should be displayed at PC section and work properly.")
    public static void testSearchForIphFromPCsection() throws Exception {
        search.openHomePage();
        search.navigateTo("/index.php?route=product/category&path=20_26");
        search.validateSearchBarIsDisplayed();
        search.searchInformation("Iph");
        search.validateSearchResults("Iphone");
    }

    @Test(description = "Validate search bar works from laptop section", priority = 1)
    @Description("Test Description: Search bar should be displayed at laptop section and work properly.")
    public static void testSearchDescription() throws Exception {
        search.openHomePage();
        search.navigateTo("/index.php?route=product/category&path=18_46");
        search.validateSearchBarIsDisplayed();
        search.searchInformation("Lorem ipsum is a pseudo-Latin");
        search.clickCheckBoxToSearchProductDescriptions();
        search.searchInformationInCriteriaSection("Lorem ipsum is a pseudo-Latin");
        search.productDescriptionContainsSearchedString("Lorem ipsum is a pseudo-Latin");

    }

    @Test(description = "Validate search bar works from monitor section", priority = 1)
    @Description("Test Description: Search bar should be displayed at monitor section and work properly.")
    public static void testSearchBarMonitorSection() throws Exception {
        search.openHomePage();
        search.navigateTo("index.php?route=product/category&path=18_46");
        search.validateSearchBarIsDisplayed();
        search.searchInformation("monir");
        search.validateSearchResults("Phone");
    }
}

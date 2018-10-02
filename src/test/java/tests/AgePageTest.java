package tests;

import helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.AgePage;

import static helpers.Driver.getDriver;

@Epic("Test 1")
@Feature("Feature 1")
@Listeners({ TestListener.class })
public class AgePageTest {

    private WebDriver driver;
    private static AgePage agePage;

    public AgePageTest() {
        driver = getDriver();
        agePage = PageFactory.initElements(driver, AgePage.class);
        agePage.setDriver(driver);
    }

    @Test(description = "Validate Age Functionality", priority = 1)
    @Description("Test Description: Check message for kid.")
    public static void testAgePageForKid() throws Exception {
        agePage.openAgeUrl();
        agePage.enterNameAndAgeAndSubmit("Ann", "5");
        agePage.checkMessageText("Hello, Ann, you are a kid");
    }

    @Test(description = "Validate Age Functionality", priority = 1)
    @Description("Test Description: Check message for adult.")
    public static void testAgePageForAdult() throws Exception {
        agePage.openAgeUrl();
        agePage.enterNameAndAgeAndSubmit("Ann", "25");
        agePage.checkMessageText("Hello, Ann, you are a adult");
    }
}

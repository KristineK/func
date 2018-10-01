package tests;

import com.sun.org.glassfish.gmbal.Description;
import helpers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.AgePage;

import static helpers.Driver.getDriver;

public class AgePageTest {

    private WebDriver driver;
    private static AgePage agePage;

    public AgePageTest() {
        driver = getDriver();
        agePage = PageFactory.initElements(driver, AgePage.class);
        agePage.setDriver(driver);
    }

    @Test
    @Description("Some detailed test description")
    public static void testAgePage() throws Exception {
        agePage.openAgeUrl();
        agePage.enterNameAndAgeAndSubmit("Ann", "5");
        agePage.checkMessageText("Hello, Ann, you are a kid");
    }
}

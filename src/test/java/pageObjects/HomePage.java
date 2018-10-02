package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage {
    public String pageURL;
    protected WebDriver driver;

    public HomePage() throws Exception {
        pageURL = System.getProperty("baseUrl");
    }

    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }

    @Step("Open homepage")
    public void openHomePage() throws IOException {
        driver.get(pageURL);
    }
}

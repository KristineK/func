package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCart {

    protected String pageURL;
    protected WebDriver driver;

    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement firstName;

    public ShoppingCart() throws Exception {
        pageURL = System.getProperty("baseUrl");
    }

    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }


}

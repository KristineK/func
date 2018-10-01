package pageObjects;

import helpers.Driver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AgePage {
    protected String pageURL;
    protected WebDriver driver;

    @FindBy(how = How.ID, using = "name")
    private WebElement name;
    @FindBy(how = How.ID, using = "age")
    private WebElement age;
    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;
    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    public AgePage() throws Exception {
        pageURL = System.getProperty("homePageUrl") + "/site/examples/age";
    }

    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }

    public void openAgeUrl() throws IOException {
        driver.get(pageURL);
    }

    public void enterNameAndAgeAndSubmit(@NotNull String nameValue, @NotNull String ageValue) {
        name.clear();
        name.sendKeys(nameValue);
        age.clear();
        age.sendKeys(ageValue);
        submitButton.click();
    }

    public void checkMessageText(@NotNull String messageText) {
        assertThat(message.getText()).isEqualToIgnoringCase(messageText);
    }
}

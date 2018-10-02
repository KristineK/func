package pageObjects;

import helpers.Driver;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static helpers.Driver.waitForElementPresent;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationPage {
    protected String pageURL;
    protected WebDriver driver;

    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement firstName;
    @FindBy(how = How.ID, using = "input-lastname")
    private WebElement lastName;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement email;
    @FindBy(how = How.ID, using = "input-telephone")
    private WebElement telephone;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement password;
    @FindBy(how = How.ID, using = "input-confirm")
    private WebElement confirmPassword;
    @FindBy(how = How.XPATH, using = "//input[@value= '1' and @name='newsletter']")
    private WebElement YesSubscribeRadioButton;
    @FindBy(how = How.XPATH, using = "//input[@value= '0' and @name='newsletter']")
    private WebElement NoSubscribeRadioButton;
    @FindBy(how = How.XPATH, using = "//input[@value= '1' and @name='agree']")
    private WebElement PrivacyPolicyAgree;
    @FindBy(how = How.XPATH, using = "//div[@class= 'pull-right']")
    private WebElement PrivacyPolicyAgreeText;
    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    private WebElement ContinueBtn;
    @FindBy(how = How.XPATH, using = "//div[@id= 'content']/p[1]")
    private WebElement CongratulationsMsgText;
    @FindBy(how = How.CLASS_NAME, using = "caret")
    private WebElement MyAccountDropDown;
    @FindBy(how = How.XPATH, using = "//*[contains(@href, 'logout')]")
    private WebElement LogOutBtn;



    public RegistrationPage() throws Exception {
        pageURL = System.getProperty("baseUrl") + "/index.php?route=account/register";
    }

    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }

    @Step("Open registartion page")
    public void openRegistrationUrl() throws IOException {
        driver.get(pageURL);
    }

    @Step("Register a user")
    public void fillRegistartionFormAndSubmit(@NotNull String firstnameValue,
                                              @NotNull String lastameValue,
                                              @NotNull String telephoneValue,
                                              @NotNull String passwordValue) {
        Random random = new Random();
        int x = random.nextInt(26);
        String randomemail =  "admin" + random  + "asd.com";

        firstName.sendKeys(firstnameValue);
        lastName.sendKeys(lastameValue);
        email.sendKeys(randomemail);
        telephone.sendKeys(telephoneValue);
        password.sendKeys(passwordValue);
        confirmPassword.sendKeys(passwordValue);
    }
    @Step("No subscription is selected")
    public void checkNoSubscribeSelected() {
        assertThat(NoSubscribeRadioButton.isSelected()).as("No subscription isn't selected").isTrue();
        assertThat(YesSubscribeRadioButton.isSelected()).as("Yes subscription isn't selected").isFalse();
    }
    @Step("Verify privacy policy text and agree")
    public void agreePrivacyPolicy(@NotNull String messageText) {
        assertThat(PrivacyPolicyAgreeText.getText().compareToIgnoreCase(messageText));
        PrivacyPolicyAgree.click();

    }
    @Step("Press Continue")
    public void pressContinueBtn() {
        ContinueBtn.click();
    }
    @Step("Verify user are register")
    public void verifyUserAreRegister(@NotNull String congratulationsText) {
        waitForElementPresent(CongratulationsMsgText);
        assertThat(CongratulationsMsgText.getText()).isEqualTo(congratulationsText);
    }

    @Step("Log out to system")
    public void logOut(@NotNull String congratulationsText) {
        MyAccountDropDown.click();
        LogOutBtn.click();
        


    }


}

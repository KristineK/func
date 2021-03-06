package pageObjects;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

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
    private WebElement logOutBtn;
    @FindBy(how = How.XPATH, using = "//*[contains(@id, 'content')]/p[1]")
    private WebElement logOutText;
    @FindBy(how = How.XPATH, using = "//*[contains(@href, 'login') and (@class)]")
    private WebElement signInBtn;
    @FindBy(how = How.XPATH, using = "//input[@value= 'Login']")
    private WebElement logInBtn;
    @FindBy(how = How.XPATH, using = "//*[contains(@href, 'account/edit')]")
    private WebElement editAccountBtn;


    public RegistrationPage() throws Exception {
        pageURL = System.getProperty("baseUrl") + "/index.php?route=account/register";
    }

    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }

    @Step("Open registartion page")
    public void openRegistrationUrl() throws IOException {
        // workaround for the login
        driver.manage().deleteAllCookies();
        driver.get(pageURL);
    }

    @Step("Register a user")
    public void fillRegistrationFormAndSubmit(@NotNull String firstnameValue,
                                              @NotNull String lastameValue,
                                              @NotNull String telephoneValue,
                                              @NotNull String passwordValue, @NotNull String emailValue) {
        firstName.sendKeys(firstnameValue);
        lastName.sendKeys(lastameValue);
        email.sendKeys(emailValue);
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

    @Step("Log out to system and see logOut message")
    public void logOut(@NotNull String LogOutText) {
        MyAccountDropDown.click();
        waitForElementPresent(logOutBtn);
        logOutBtn.click();
        assertThat(logOutText.getText()).isEqualTo(LogOutText);
    }

    @Step("Sing-In to system")
    public void logIn(@NotNull String emailValue, @NotNull String passwordValue) {
        signInBtn.click();
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
        logInBtn.click();
    }

    @Step("select edit account")
    public void selectEditAccount() {
        editAccountBtn.click();

    }

    @Step("verify account details")
    public void verifyAccountDetails(@NotNull String firstnameValue,
                                     @NotNull String lastameValue,
                                     @NotNull String telephoneValue,
                                     @NotNull String emailValue) {


        waitForElementPresent(firstName);
        assertThat(firstName.getAttribute(firstnameValue));
        assertThat(lastName.getAttribute(lastameValue));
        assertThat(email.getAttribute(telephoneValue));
        assertThat(telephone.getAttribute(emailValue));

    }

    @Step("verify email error message")
    public void verifyAccountDetails() {
        assertThat(CongratulationsMsgText.isEnabled()).isFalse();
    }


}

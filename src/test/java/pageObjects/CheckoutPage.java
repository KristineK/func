package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

import static helpers.Driver.waitForElementPresent;

public class CheckoutPage {
    protected String pageURL;
    protected WebDriver driver;


    @FindBy(how = How.ID, using = "button-account")
    private WebElement continueAccount;
    @FindBy(how = How.ID, using = "button-login")
    private WebElement continueButton;
    @FindBy(how = How.ID, using = "button-guest")
    private WebElement continueButtonForGuest;
    @FindBy(how = How.ID, using = "button-payment-method")
    private WebElement continueButtonForPaymentMethod;
    @FindBy(how = How.ID, using = "button-confirm")
    private WebElement confirmOrderButton;
    @FindBy(how = How.ID, using = "input-payment-firstname")
    private WebElement firstName;
    @FindBy(how = How.ID, using = "input-payment-lastname")
    private WebElement lastName;
    @FindBy(how = How.ID, using = "input-payment-email")
    private WebElement email;
    @FindBy(how = How.ID, using = "input-payment-telephone")
    private WebElement phoneNumber;
    @FindBy(how = How.ID, using = "input-payment-address-1")
    private WebElement adress1;
    @FindBy(how = How.ID, using = "input-payment-city")
    private WebElement city;
    @FindBy(how = How.ID, using = "input-payment-postcode")
    private WebElement postCode;
    @FindBy(how = How.XPATH, using = "//input[@value= 'guest']")
    private WebElement guestCheckBox;
    @FindBy(how = How.XPATH, using = "//input[@name= 'agree']")
    private WebElement agreeCheckBox;
    @FindBy(how = How.XPATH, using = "//input[@id= 'input-payment-zone']")
    private WebElement paymentZone;
    @FindBy(how = How.XPATH, using = "//select[@id= 'input-payment-zone']/option[2]")
    private WebElement paymentZoneCity;


    public CheckoutPage() throws Exception {
        pageURL = System.getProperty("baseUrl") + "/index.php?route=checkout/cart";
    }

    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }

    @Step("Open checkout page")
    public void openRegistrationUrl() throws IOException {
        driver.get(pageURL);
    }

    @Step("Open homepage")
    public void openHomePage() {
        driver.get(System.getProperty("baseUrl"));
    }

    @Step("Add to cart 1st item on Feature slice")
    public void addToCartFirstItemOnFeatureSlice() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]/span")).click();
    }

    @Step("Navigate to checkout page directly")
    public void navigateToCheckoutPage() {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a")).click();

    }

    @Step("Continue checkout as guest user")
    public void clickContinueButtonAsGuest() {
        waitForElementPresent(guestCheckBox);
        guestCheckBox.click();
        continueAccount.click();
    }

    @Step("Fill correct billing details")
    public void fillCorrectBillingDetails() {
        waitForElementPresent(firstName);
        firstName.sendKeys("John");
        lastName.sendKeys("Smith");
        email.sendKeys("john.smith123@gmail.com");
        phoneNumber.sendKeys("+37122222222");
        adress1.sendKeys("Some street 22");
        city.sendKeys("Riga");
        paymentZone.click();
        driver.findElement(By.xpath("//*[@id=\"input-payment-zone\"]/option[129]")).click();
        continueButtonForGuest.click();
    }

    @Step("Accept to terms and conditions and continue")
    public void acceptToTermsAndConditions() {
        waitForElementPresent(agreeCheckBox);
        agreeCheckBox.click();
        continueButtonForPaymentMethod.click();
    }

    @Step("Confirm order")
    public void clickConfirmOrder() {
        waitForElementPresent(confirmOrderButton);
        confirmOrderButton.click();
    }
}
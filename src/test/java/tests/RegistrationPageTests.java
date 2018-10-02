package tests;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;
import static helpers.Driver.getDriver;

public class RegistrationPageTests {

    private WebDriver driver;
    private static RegistrationPage registrationPage;

    public RegistrationPageTests() {
        driver = getDriver();
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.setDriver(driver);
    }

    @Test(description = "User Registartion", priority = 1)
    @Description("Test Description: Register a user")
    public static void testUserRegistration() throws Exception {
        registrationPage.openRegistrationUrl();
        registrationPage.fillRegistartionFormAndSubmit("FirstName", "LastName", "1111", "password");
        registrationPage.agreePrivacyPolicy("I have read and agree to the ");
        registrationPage.pressContinueBtn();
        registrationPage.verifyUserAreRegister("Congratulations! Your new account has been successfully created!");

    }
    @Test(description = "User Registartion fields", priority = 1)
    @Description("Test Description: Check Radio button subscribe by default No")
    public static void testRadioButton() throws Exception {
        registrationPage.openRegistrationUrl();
        registrationPage.checkNoSubscribeSelected();
    }

    @Test(description = "After registration user are able to login", priority = 1)
    @Description("Test Description: After registration login to system")
    public static void loginToSystem() throws Exception {
        registrationPage.openRegistrationUrl();
        registrationPage.fillRegistartionFormAndSubmit("FirstName", "LastName", "1111", "password");
        registrationPage.agreePrivacyPolicy("I have read and agree to the ");
        registrationPage.pressContinueBtn();

    }


}

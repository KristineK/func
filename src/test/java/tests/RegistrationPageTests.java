package tests;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;

import java.util.Random;

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
        Random random = new Random();
        int x = random.nextInt(26);
        String randomemail =  "admin" + random  + "asd.com";
        registrationPage.openRegistrationUrl();
        registrationPage.fillRegistrationFormAndSubmit("FirstName", "LastName", "1111", "password",randomemail);
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
        Random random = new Random();
        int x = random.nextInt(100);
        String randomemail =  "admin" + x  + "@asd.com";
        String password ="password";
        String firstName ="FirstName";
        String lastName ="LastName";
        String telephone = "1111";
        registrationPage.openRegistrationUrl();
        registrationPage.fillRegistrationFormAndSubmit(firstName, lastName, telephone, password, randomemail);
        registrationPage.agreePrivacyPolicy("I have read and agree to the ");
        registrationPage.pressContinueBtn();
        registrationPage.logOut("You have been logged off your account. It is now safe to leave the computer.");
        registrationPage.logIn(randomemail, password);
        registrationPage.selectEditAccount();
        registrationPage.verifyAccountDetails(firstName, lastName, randomemail, telephone );
    }

    @Test(description = "Verify email validation", priority = 1)
    @Description("Verify email validation error message")
    public static void emailValidation() throws Exception {
        String email = "email";
        String password ="password";
        String firstName ="FirstName";
        String lastName ="LastName";
        String telephone = "1111";
        registrationPage.openRegistrationUrl();
        registrationPage.fillRegistrationFormAndSubmit(firstName, lastName, telephone, password, email);
        registrationPage.agreePrivacyPolicy("I have read and agree to the ");
        registrationPage.pressContinueBtn();

    }



}

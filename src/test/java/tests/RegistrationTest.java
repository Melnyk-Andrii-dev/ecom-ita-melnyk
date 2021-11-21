package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;
    String confirmationError = "Password confirmation does not match password!";
    String alreadyRegisteredError = "Warning: E-Mail Address is already registered!";

    @Test
    void successfullRegistration(){
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Register");
        registrationPage = new RegistrationPage();
        registrationPage.inputRegistrationForm("firstname", "Test");
        registrationPage.inputRegistrationForm("lastname", "Toster");
        registrationPage.inputRegistrationForm("email", "test5@mail.com");
        registrationPage.inputRegistrationForm("telephone", "0974152014");
        registrationPage.inputRegistrationForm("password", "test1234");
        registrationPage.inputRegistrationForm("confirm", "test1234");
        registrationPage.clickSubscribeRadioNo();
        registrationPage.clickConsentCheckbox();
        registrationPage.clickContinueButton();
        Assertions.assertThat(loginPage.getHeaderComponent().isLoginDisplayed()).isEqualTo(false);
    }

    @Test
    void failRegistrationPrivacyPolicyUnselected(){
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Register");
        registrationPage = new RegistrationPage();
        registrationPage.inputRegistrationForm("firstname", "Test");
        registrationPage.inputRegistrationForm("lastname", "Toster");
        registrationPage.inputRegistrationForm("email", "test2@mail.com");
        registrationPage.inputRegistrationForm("telephone", "0974152014");
        registrationPage.inputRegistrationForm("password", "test1234");
        registrationPage.inputRegistrationForm("confirm", "test1234");
        registrationPage.clickSubscribeRadioYes();
        registrationPage.clickContinueButton();
        Assertions.assertThat(loginPage.getHeaderComponent().isLoginDisplayed()).isEqualTo(true);
    }

    @Test
    void failRegistrationInvalidEmail(){
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Register");
        registrationPage = new RegistrationPage();
        registrationPage.inputRegistrationForm("firstname", "Test");
        registrationPage.inputRegistrationForm("lastname", "Toster");
        registrationPage.inputRegistrationForm("email", "test3@mai@l.com");
        registrationPage.inputRegistrationForm("telephone", "0974152014");
        registrationPage.inputRegistrationForm("password", "test1234");
        registrationPage.inputRegistrationForm("confirm", "test1234");
        registrationPage.clickSubscribeRadioYes();
        registrationPage.clickConsentCheckbox();
        registrationPage.clickContinueButton();
        Assertions.assertThat(loginPage.getHeaderComponent().isLoginDisplayed()).isEqualTo(true);
    }

    @Test
    void passwordValidation(){
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Register");
        registrationPage = new RegistrationPage();
        registrationPage.inputRegistrationForm("firstname", "Test");
        registrationPage.inputRegistrationForm("lastname", "Toster");
        registrationPage.inputRegistrationForm("email", "test4@mail.com");
        registrationPage.inputRegistrationForm("telephone", "0974152014");
        registrationPage.inputRegistrationForm("password", "test1234");
        registrationPage.inputRegistrationForm("confirm", "test12345");
        registrationPage.clickSubscribeRadioYes();
        registrationPage.clickConsentCheckbox();
        registrationPage.clickContinueButton();


        Assertions.assertThat(registrationPage.getValidationError("confirmation")).isEqualTo(confirmationError);
        Assertions.assertThat(loginPage.getHeaderComponent().isLoginDisplayed()).isEqualTo(true);
    }

    @Test
    void alreadyRegisteredErrorValidation(){
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Register");
        registrationPage = new RegistrationPage();
        registrationPage.inputRegistrationForm("firstname", "Test");
        registrationPage.inputRegistrationForm("lastname", "Toster");
        registrationPage.inputRegistrationForm("email", "sajowi9588@epeva.com");
        registrationPage.inputRegistrationForm("telephone", "0974152014");
        registrationPage.inputRegistrationForm("password", "test1234");
        registrationPage.inputRegistrationForm("confirm", "test1234");
        registrationPage.clickSubscribeRadioYes();
        registrationPage.clickConsentCheckbox();
        registrationPage.clickContinueButton();
        Assertions.assertThat(registrationPage.getAlreadyRegisteredError()).isEqualTo(alreadyRegisteredError);
        Assertions.assertThat(loginPage.getHeaderComponent().isLoginDisplayed()).isEqualTo(true);
    }
}

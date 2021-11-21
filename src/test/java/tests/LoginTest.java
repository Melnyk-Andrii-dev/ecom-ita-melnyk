package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.assertj.core.api.Assertions;
import pages.BasePage;
import pages.HeaderComponent;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    private static final String loginErrorExpectedText = "Warning: No match for E-Mail Address and/or Password.";

    @Test
    void errorAllertValidationOnLoginPage() {
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Login");
        loginPage.inputEmailToEmailField("test@gmail.com");
        loginPage.inputPasswordToEmailField("1234");
        loginPage.clickSubmitButton();
        String loginErrorActualMessage = loginPage.getLoginErrorActualMessage();
        Assertions.assertThat(loginErrorActualMessage).as("error message is different")
                .isEqualTo(loginErrorExpectedText);
    }

    @Test
    void successfullLogin(){
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Login");
        loginPage.inputEmailToEmailField("sajowi9588@epeva.com");
        loginPage.inputPasswordToEmailField("123123");
        loginPage.clickSubmitButton();
        Assertions.assertThat(loginPage.getHeaderComponent().isLoginDisplayed()).isEqualTo(false);
    }

    @Test
    void failLoginNoCredentials(){
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Login");
        loginPage.clickSubmitButton();
        Assertions.assertThat(loginPage.getHeaderComponent().isLoginDisplayed()).isEqualTo(true);
    }

    @Test
    void failLoginInvalidPassword(){
        loginPage = new LoginPage();
        loginPage.getHeaderComponent().chooseFromDropdown("Login");
        loginPage.inputEmailToEmailField("sajowi9588@epeva.com");
        loginPage.inputPasswordToEmailField("1231231");
        loginPage.clickSubmitButton();
        Assertions.assertThat(loginPage.getHeaderComponent().isLoginDisplayed()).isEqualTo(true);
    }

}
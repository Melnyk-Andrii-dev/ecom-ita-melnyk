package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.assertj.core.api.Assertions;
import pages.BasePage;
import pages.HeaderPage;
import pages.LoginPage;

public class LoginTest extends BasePage {
    LoginPage loginPage;

    private static final String loginErrorExpectedText = "Warning: No match for E-Mail Address and/or Password.";
    private static final String successIndicator = "Logout";



    @Test
    void errorAllertValidationOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.headerPage.clickAccountDropdown();
        loginPage.headerPage.clickLoginFromDropdown();
        loginPage.inputEmailToEmailField("test@gmail.com");
        loginPage.inputPasswordToEmailField("1234");
        loginPage.clickSubmitButton();
        String loginErrorActualMessage = loginPage.getLoginErrorActualMessage();
        Assertions.assertThat(loginErrorActualMessage).as("error message is different")
                .isEqualTo(loginErrorExpectedText);
    }

    @Test
    void successfullLogin(){
        loginPage = new LoginPage(driver);
        loginPage.headerPage.clickAccountDropdown();
        loginPage.headerPage.clickLoginFromDropdown();
        loginPage.inputEmailToEmailField("sajowi9588@epeva.com");
        loginPage.inputPasswordToEmailField("123123");
        loginPage.clickSubmitButton();
        String actualState = loginPage.headerPage.getLoginIndicator();
        Assertions.assertThat(actualState).as("login error").isEqualTo(successIndicator);
    }

    @Test
    void failLoginNoCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.headerPage.clickAccountDropdown();
        loginPage.headerPage.clickLoginFromDropdown();
        loginPage.clickSubmitButton();
        String actualState = loginPage.headerPage.getLoginIndicator();
        Assertions.assertThat(actualState).as("user logged in").isNotEqualTo(successIndicator);
    }

    @Test
    void failLoginInvalidPassword(){
        loginPage = new LoginPage(driver);
        loginPage.headerPage.clickAccountDropdown();
        loginPage.headerPage.clickLoginFromDropdown();
        loginPage.inputEmailToEmailField("sajowi9588@epeva.com");
        loginPage.inputPasswordToEmailField("1231231");
        loginPage.clickSubmitButton();
        String actualState = loginPage.headerPage.getLoginIndicator();
        Assertions.assertThat(actualState).as("user logged in").isNotEqualTo(successIndicator);
    }

}

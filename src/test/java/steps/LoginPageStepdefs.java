package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginPageStepdefs {
    private static final LoginPage loginPage = new LoginPage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();

    @Given("Login page is opened in header dropdown")
    public void loginPageIsOpenedInHeaderDropdown() {
        loginPage.getHeaderComponent().chooseFromDropdown("Login");
    }

    @When("I enter email {string} on Login page")
    public void iEnterEmailSajowEpevaComOnLoginPage(String email) {
        loginPage.inputEmailToEmailField(email);
    }

    @And("I enter password {string} on Login page")
    public void iEnterPasswordOnLoginPage(String password) {
        loginPage.inputPasswordToEmailField(password);
    }

    @And("I click the Login button on Login Page")
    public void iClickTheLoginButtonOnLoginPage() {
        loginPage.clickSubmitButton();
    }

    @Then("My Account Page is displayed")
    public void myAccountPageIsDisplayed() {
        Assertions.assertThat(myAccountPage.isMyaccountPageOpened()).as("not My Account Page is displayed").isEqualTo(true);
    }

    @Given("Login page is opened")
    public void loginPageIsOpened() {
        loginPage.getHeaderComponent().chooseFromDropdown("Login");
    }

    @When("I enter unregistered email {string}")
    public void iEnterUnregisteredEmailTestMailCom(String email) {
        loginPage.inputEmailToEmailField(email);
    }

    @And("I enter any password, e.g. {string}")
    public void iEnterAnyPasswordEG(String password) {
        loginPage.inputPasswordToEmailField(password);
    }


    @And("I click the Login button")
    public void iClickTheLoginButton() {
        loginPage.clickSubmitButton();
    }

    @Then("The error message {string} is displayed")
    public void theErrorMessageWarningNoMatchForEMailAddressAndOrPasswordIsDisplayed(String error) {
        Assertions.assertThat(loginPage.getLoginErrorActualMessage()).as("No valid error message is displayed").isEqualTo(error);
    }
}

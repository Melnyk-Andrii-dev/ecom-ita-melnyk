package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.RegistrationPage;

public class RegistrationPageStepdefs {
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("Registration Page is opened")
    public void registrationPageIsOpened() {
        registrationPage.getHeaderComponent().chooseFromDropdown("Register");
    }

    @When("The user inputs {string} field with {string}")
    public void theUserInputsFirstnameFieldWithFirst(String field, String value) {
        registrationPage.inputRegistrationForm(field, value);
    }

    @And("The user chooses subscription - NO")
    public void theUserChoosesSubscriptionNO() {
        registrationPage.clickSubscribeRadioNo();
    }

    @And("The user selects Privacy Policy checkbox")
    public void theUserSelectsPrivacyPolicyCheckbox() {
        registrationPage.clickConsentCheckbox();
    }

    @And("The user clicks Continue button")
    public void theUserClicksContinueButton() {
        registrationPage.clickContinueButton();
    }

    @Then("The user have a Logout option on Global Header")
    public void theUserHaveALogoutOptionOnGlobalHeader() {
        Assertions.assertThat(registrationPage.getHeaderComponent().isLoginDisplayed()).as("Logout is not displayed (user is not registered)").isEqualTo(false);
    }

    @And("The user chooses subscription - YES")
    public void theUserChoosesSubscriptionYES() {
        registrationPage.clickSubscribeRadioYes();
    }

    @And("The user have a Login option on Global Header")
    public void theUserHaveALoginOptionOnGlobalHeader() {
        Assertions.assertThat(registrationPage.getHeaderComponent().isLoginDisplayed()).as("Logout is displayed (user is registered)").isEqualTo(true);
    }


    @Then("The error message {string} is displayed on field level")
    public void theErrorMessageErrorIsDisplayedOnFieldLevel(String error) {
        Assertions.assertThat(registrationPage.getValidationError("confirmation")).isEqualTo(error);
    }

    @Then("The error message {string} is displayed on page level")
    public void theErrorMessageErrorIsDisplayedOnPageLevel(String error) {
        Assertions.assertThat(registrationPage.getAlreadyRegisteredError()).isEqualTo(error);
    }
}

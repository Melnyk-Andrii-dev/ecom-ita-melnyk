package steps;

import enums.TableFields;
import enums.elements.RegistrationPageInputField;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.assertj.core.api.Assertions;
import pages.RegistrationPage;

import java.util.Map;

public class RegistrationPageStepdefs {
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("Registration Page is opened")
    public void registrationPageIsOpened() {
        registrationPage.implicitlyWait();
        registrationPage.getHeaderComponent().chooseFromDropdown("Register");
    }

    @When("The user inputs {string} field with {string}")
    public void theUserInputsFirstnameFieldWithFirst(String field, String value) {
        registrationPage.implicitlyWait();
        registrationPage.inputRegistrationForm(field, value);
    }

    @And("The user chooses subscription - NO")
    public void theUserChoosesSubscriptionNO() {
        registrationPage.implicitlyWait();
        registrationPage.clickSubscribeRadioNo();
    }

    @And("The user selects Privacy Policy checkbox")
    public void theUserSelectsPrivacyPolicyCheckbox() {
        registrationPage.implicitlyWait();
        registrationPage.clickConsentCheckbox();
    }

    @And("The user clicks Continue button")
    public void theUserClicksContinueButton() {
        registrationPage.implicitlyWait();
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

    @When("The user inputs text into field on Registration Page:")
    public void theUserInputsTextIntoFieldOnRegistrationPage(DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            String field = map.get(TableFields.FIELD.toString());
            String text = map.get(TableFields.TEXT.toString());
            registrationPage.inputRegistrationForm(field, text);
        }
    }

    @And("The user inputs enum {} field with {string}")
    public void theUserInputsEnumFieldWithTest(RegistrationPageInputField field, String text) {
        registrationPage.inputRegistrationFormWithEnum(field, text);
    }
}

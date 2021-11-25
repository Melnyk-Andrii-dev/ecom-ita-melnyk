package steps;

import enums.elements.LoginPageInputField;
import enums.TableFields;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.LoginPage;
import pages.MyAccountPage;

import java.util.Map;

public class LoginPageStepdefs {
    private static final LoginPage loginPage = new LoginPage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();

    @Given("Login page is opened in header dropdown")
    public void loginPageIsOpenedInHeaderDropdown() {
        loginPage.getHeaderComponent().chooseFromDropdown("Login");
    }



    @When("I enter to {} field {string} value on Login Page")
    public void iInputLoginFieldsWithEnum(LoginPageInputField field, String data) {
        loginPage.inputLoginFieldsWithEnum(field, data);
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

    @And("I click the Login button")
    public void iClickTheLoginButton() {
        loginPage.clickSubmitButton();
    }

    @Then("The error message {string} is displayed")
    public void theErrorMessageWarningNoMatchForEMailAddressAndOrPasswordIsDisplayed(String error) {
        Assertions.assertThat(loginPage.getLoginErrorActualMessage()).as("No valid error message is displayed").isEqualTo(error);
    }

    @When("I enter text into field on Login Page:")
    public void iEnterTextIntoFieldOnLoginPage(DataTable table) {
        for (Map<String, String> row : table.asMaps()) {
            String data = row.get(TableFields.INPUT_DATA.toString());
            String field = row.get(TableFields.FIELD_NAME.toString());
            loginPage.inputLoginFieldsWithTable(field, data);
        }


    }
}

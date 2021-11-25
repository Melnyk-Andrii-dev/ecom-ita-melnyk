package pages;

import enums.elements.LoginPageInputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private static final String SUBMIT_LOGIN_BUTTON = "//input[@type='submit']";
    private static final String LOGIN_ERROR_ALLERT = "//div[contains(@class, 'alert')]";
    private static final String LOGIN_PAGE_INPUT_FIELD = "//input[@name='%s']";


    public void clickSubmitButton() {
        findElementBy(By.xpath(SUBMIT_LOGIN_BUTTON)).click();
    }

    public String getLoginErrorActualMessage() {
        return findElementBy(By.xpath(LOGIN_ERROR_ALLERT)).getText();
    }

    public void inputLoginFieldsWithEnum(LoginPageInputField field, String data) {
        findElementBy(By.xpath(String.format(LOGIN_PAGE_INPUT_FIELD, field.toString()))).sendKeys(data);
    }

    public void inputLoginFieldsWithTable(String field, String data){
        findElementBy(By.xpath(String.format(LOGIN_PAGE_INPUT_FIELD, field))).sendKeys(data);
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private static final String INPUT_FIELD_SECTION = "input-%s";
    private static final String SUBSCRIBE_RADIO = "//label[@class='radio-inline']//descendant::input[@name='newsletter' and @value='%s']";
    private static final String PRIVACYCONSENT_CHECKBOX = "//div[@class='pull-right']//input[@name='agree']";
    private static final String CONTINUE_BUTTON = "//div[@class='pull-right']//input[@value='Continue']";
    private static final String VALIDATION_ERROR = "//div[@class='text-danger' and contains(text(), '%s')]";
    private static final String GENERAL_ERROR = "//ul[@class='breadcrumb']//following-sibling::div[contains(text(), '%s')]";

    public void inputRegistrationForm(String field, String input){ findElementBy(By.id
            (String.format(INPUT_FIELD_SECTION, field))).sendKeys(input);}

    public void clickSubscribeRadioYes(){ findElementBy(By.xpath
            (String.format(SUBSCRIBE_RADIO, "1"))).click();}

    public void clickSubscribeRadioNo(){ findElementBy(By.xpath
            (String.format(SUBSCRIBE_RADIO, "0"))).click();}

    public void clickConsentCheckbox(){ findElementBy(By.xpath(PRIVACYCONSENT_CHECKBOX)).click();}

    public void clickContinueButton(){ findElementBy(By.xpath(CONTINUE_BUTTON)).click();}

    public String getValidationError(String field){ return findElementBy(By.xpath
            (String.format(VALIDATION_ERROR, field))).getText();}

    public String getPrivacyConsentError(){ return findElementBy(By.xpath
            (String.format(GENERAL_ERROR, "Privacy"))).getText();}

    public String getAlreadyRegisteredError(){ return findElementBy(By.xpath
            (String.format(GENERAL_ERROR, "registered"))).getText();}

}
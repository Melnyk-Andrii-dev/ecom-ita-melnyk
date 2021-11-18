package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {
    public HeaderComponent(WebDriver driver){this.driver = driver;};

    private static final String LOGIN_STATUS = "//ul[contains(@class, 'menu-right')]/descendant::a[contains(text(),'Log')]";
    private static final String CURRENCY_BUTTON = "//div[@class='btn-group open']/button[contains(@class, 'dropdown-toggle')]";
    private static final String CURRENCY_CONTENT = "//ul[@class='dropdown-menu']//button[@name='%s']";
    private static final String CONTACT_US = "//i[contains(@class, 'fa-phone')]/parent::a";
    private static final String MY_ACCOUNT_BUTTON = "//span[contains(text(), 'Account')]";
    private static final String MY_ACCOUNT_CONTENT = "//ul[contains(@class, 'menu-right')]/descendant::a[text()='%s']";
    private static final String WISHLIST_BUTTON = "wishlist-total";
    private static final String SHOPPINGCART_BUTTON = "//li//a[@title='Shopping Cart']";
    private static final String CHECKOUT_BUTTON = "//li//a[@title='Checkout']";


    public void chooseCurrency(String currency) {
        findElementBy(By.xpath(CURRENCY_BUTTON)).click();
        findElementBy(By.xpath(String.format(CURRENCY_CONTENT, currency))).click();
    }

    public void clickContactUs() { findElementBy(By.xpath(CONTACT_US)).click(); };

    public void clickRegisterFromDropdown() { findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, "Register"))).click(); }

    public boolean isLoginDisplayed() {
        findElementBy(By.xpath(MY_ACCOUNT_BUTTON)).click();
        return findElementBy(By.xpath(LOGIN_STATUS)).getText().equals("Login"); } // CHANGE!!!!!!!!

    public void chooseFromDropdown(String option) {
        findElementBy(By.xpath(MY_ACCOUNT_BUTTON)).click();
        findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, option))).click();
    }

    public void clickWishlistButton() { findElementBy(By.id(WISHLIST_BUTTON)).click(); }

    public void clickShoppingCartButton() { findElementBy(By.xpath(SHOPPINGCART_BUTTON)).click(); }

    public void clickCheckoutButton() { findElementBy(By.xpath(CHECKOUT_BUTTON)).click(); }

}
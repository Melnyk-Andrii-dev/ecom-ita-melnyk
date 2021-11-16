package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public HeaderPage(WebDriver driver){this.driver = driver;};

    private static final String CURRENCY_BUTTON = "//div[@class='btn-group open']/button[contains(@class, 'dropdown-toggle')]";
    private static final String CURRENCY_CONTENT = "//ul[@class='dropdown-menu']//button[@name='%s']";
    private static final String CONTACT_US = "//i[contains(@class, 'fa-phone')]/parent::a";
    private static final String MY_ACCOUNT_BUTTON = "//span[contains(text(), 'Account')]";
//    private static final String REGISTER_BUTTON = "//ul[contains(@class, 'menu-right')]/descendant::a[text()='Register']";
//    private static final String LOGIN_DROPDOWN_BUTTON = "//li[contains(@class, 'dropdown')]//following::a[text()='Login']";
    private static final String MY_ACCOUNT_CONTENT = "//ul[contains(@class, 'menu-right')]/descendant::a[text()='%s']";
    private static final String WISHLIST_BUTTON = "wishlist-total";
    private static final String SHOPPINGCART_BUTTON = "//li//a[@title='Shopping Cart']";
    private static final String CHECKOUT_BUTTON = "//li//a[@title='Checkout']";

    public void clickEuroCurrency() { findElementBy(By.xpath(String.format(CURRENCY_CONTENT, "EUR"))).click(); }

    public void clickUsdCurrency() { findElementBy(By.xpath(String.format(CURRENCY_CONTENT, "USD"))).click(); }

    public void clickGbpCurrency() { findElementBy(By.xpath(String.format(CURRENCY_CONTENT, "GBP"))).click(); }

    public void clickContactUs() { findElementBy(By.xpath(CONTACT_US)).click(); };

    public void clickAccountDropdown() {
        findElementBy(By.xpath(MY_ACCOUNT_BUTTON)).click();
    }

//    public void clickRegisterFromDropdown() {findElementBy(By.xpath(REGISTER_BUTTON)).click(); }

//    public void clickLoginFromDropdown() {findElementBy(By.xpath(LOGIN_DROPDOWN_BUTTON)).click(); }

    public void clickRegisterFromDropdown() { findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, "Register"))).click(); }

    public String getLoginIndicator() {
        clickAccountDropdown();
        return findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, "Logout"))).getText(); } // CHANGE!!!!!!!!

    public void clickLoginFromDropdown() { findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, "Login"))).click(); }

    public void clickMyAccountFromDropdown() { findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, "My Account"))).click(); }

    public void clickTransactionsFromDropdown() { findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, "Transactions"))).click(); }

    public void clickDownloadsFromDropdown() { findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, "Downloads"))).click(); }

    public void clickLogoutFromDropdown() { findElementBy(By.xpath(String.format(MY_ACCOUNT_CONTENT, "Logout"))).click(); }

    public void clickWishlistButton() { findElementBy(By.id(WISHLIST_BUTTON)).click(); }

    public void clickShoppingCartButton() { findElementBy(By.xpath(SHOPPINGCART_BUTTON)).click(); }

    public void clickCheckoutButton() { findElementBy(By.xpath(CHECKOUT_BUTTON)).click(); }

}

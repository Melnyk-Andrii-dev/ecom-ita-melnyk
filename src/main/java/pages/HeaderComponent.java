package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeaderComponent extends AbstractBasePage {

    private static final String LOGIN_STATUS = "//ul[contains(@class, 'menu-right')]/descendant::a[contains(text(),'Log')]";
    private static final String CURRENCY_BUTTON = "//div[@class='btn-group open']/button[contains(@class, 'dropdown-toggle')]";
    private static final String CURRENCY_CONTENT = "//ul[@class='dropdown-menu']//button[@name='%s']";
    private static final String CONTACT_US = "//i[contains(@class, 'fa-phone')]/parent::a";
    private static final String MY_ACCOUNT_BUTTON = "//span[contains(text(), 'Account')]";
    private static final String MY_ACCOUNT_CONTENT = "//ul[contains(@class, 'menu-right')]/descendant::a[text()='%s']";
    private static final String WISHLIST_BUTTON = "wishlist-total";
    private static final String SHOPPINGCART_BUTTON = "//li//a[@title='Shopping Cart']";
    private static final String CHECKOUT_BUTTON = "//li//a[@title='Checkout']";
    private static final String WISHLIST_INDICATOR = "//a[@id ='wishlist-total']//span";


    public void chooseCurrency(String currency) {
        findElementBy(By.xpath(CURRENCY_BUTTON)).click();
        findElementBy(By.xpath(String.format(CURRENCY_CONTENT, currency))).click();
    }

    public void clickContactUs() { findElementBy(By.xpath(CONTACT_US)).click(); };

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

    public int WishlistButtonIndicator() {
        String line =findElementBy(By.xpath(WISHLIST_INDICATOR)).getText();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(line);
        return matcher.find() ? Integer.parseInt(line.substring(matcher.start(), matcher.end())) : 0;
    }

}
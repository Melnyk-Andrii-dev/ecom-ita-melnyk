package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YourStorePage extends BasePage {

//    private final String MINICART_PRODUCTTITLES = "//table[contains(@class, 'table-striped')]//descendant::*[text()='%s']";

    public YourStorePage(){
        PageFactory.initElements(AbstractBasePage.getDriverThreadLocal(), this);
    }

    @FindBy(id = "common-home")
    WebElement yourStorePageIndicator;

    @FindBy(xpath = "//div[@id='cart']//button")
    WebElement minicartButton;

    @FindBy(xpath = "//div[@class='swiper-viewport']//div[@id='slideshow0']")
    WebElement productCarousel;

    @FindBy(xpath = "//div[@id='slideshow0']//following-sibling::div[@class='swiper-pager']//div[@class='swiper-button-prev']")
    WebElement slideButtonPrev;

    @FindBy(xpath = "//div[@id='slideshow0']//following-sibling::div[@class='swiper-pager']//div[@class='swiper-button-next']")
    WebElement slideButtonNext;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][1]//div[@class='image']//a")
    WebElement productTileImgFirst;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][1]//div[@class='caption']//a")
    WebElement productTileLinkFirst;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][1]//div[@class='button-group']//button[contains(@onclick, 'cart')]")
    WebElement productTileButtonAddToCartFirst;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][1]//div[@class='button-group']//button[contains(@onclick, 'wishlist')]")
    WebElement productTileButtonAddToWishlistFirst;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][1]//div[@class='button-group']//button[contains(@onclick, 'compare')]")
    WebElement productTileButtonCompareFirst;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][2]//div[@class='image']//a")
    WebElement productTileImgSecond;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][2]//div[@class='caption']//a")
    WebElement productTileLinkSecond;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][2]//div[@class='button-group']//button[contains(@onclick, 'cart')]")
    WebElement productTileButtonAddToCartSecond;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][2]//div[@class='button-group']//button[contains(@onclick, 'wishlist')]")
    WebElement productTileButtonAddToWishlistSecond;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][2]//div[@class='button-group']//button[contains(@onclick, 'compare')]")
    WebElement productTileButtonCompareSecond;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][3]//div[@class='image']//a")
    WebElement productTileImgThird;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][3]//div[@class='caption']//a")
    WebElement productTileLinkThird;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][3]//div[@class='button-group']//button[contains(@onclick, 'cart')]")
    WebElement productTileButtonAddToCartThird;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][3]//div[@class='button-group']//button[contains(@onclick, 'wishlist')]")
    WebElement productTileButtonAddToWishlistThird;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][3]//div[@class='button-group']//button[contains(@onclick, 'compare')]")
    WebElement productTileButtonCompareThird;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][4]//div[@class='image']//a")
    WebElement productTileImgForth;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][4]//div[@class='caption']//a")
    WebElement productTileLinkForth;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][4]//div[@class='button-group']//button[contains(@onclick, 'cart')]")
    WebElement productTileButtonAddToCartForth;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][4]//div[@class='button-group']//button[contains(@onclick, 'wishlist')]")
    WebElement productTileButtonAddToWishlistForth;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][4]//div[@class='button-group']//button[contains(@onclick, 'compare')]")
    WebElement productTileButtonCompareForth;

    @FindBy(id = "cart-total")
    WebElement cartInfo;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][1]//p[@class='price']")
    WebElement priceOfFirst;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][2]//p[@class='price']")
    WebElement priceOfSecond;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][3]//p[@class='price']")
    WebElement priceOfThird;

    @FindBy(xpath = "//div[@class ='row']//div[contains(@class, 'product-layout')][4]//p[@class='price']")
    WebElement priceOfForth;

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]//a[contains(text(), 'wish')]")
    WebElement wishlistMessage;

//    @FindBy(xpath = "//div[contains(@class, 'alert-success')]//a[contains(text(), 'comparison')]")
    @FindBy(xpath = "//div[contains(@class, 'alert-success')]//a[contains(text(), 'comparison')]//parent::div")
    WebElement compareMessage;

    public boolean isProductCarouselDisplayed(){
        return productCarousel.isDisplayed();
    }

    public void clickOnMinicartButton(){ minicartButton.click();}

    public void clickPrevOnMainSlider() {
        slideButtonPrev.click();
    }

    public void clickNextOnMainSlider() {
        slideButtonNext.click();
    }

    public void clickOnImgFirst() {
        productTileImgFirst.click();
    }

    public void clickOnTitleFirst() {
        productTileLinkFirst.click();
    }

    public String getProductTitleFirst() {
        return productTileLinkFirst.getText();
    }

    public void addToCartFirst() {
        productTileButtonAddToCartFirst.click();
    }

    public void addToWishlistFirst() {
        productTileButtonAddToWishlistFirst.click();
    }

    public void compareFirst() {
        productTileButtonCompareFirst.click();
    }

    public void clickOnImgSecond() {
        productTileImgSecond.click();
    }

    public void clickOnTitleSecond() {
        productTileLinkSecond.click();
    }

    public String getProductTitleSecond() {
        return productTileLinkSecond.getText();
    }

    public void addToCartSecond() {
        productTileButtonAddToCartSecond.click();
    }

    public void addToWishlistSecond() {
        productTileButtonAddToWishlistSecond.click();
    }

    public void compareSecond() {
        productTileButtonCompareSecond.click();
    }

    public void clickOnImgThird() {
        productTileImgThird.click();
    }

    public void clickOnTitleThird() {
        productTileLinkThird.click();
    }

    public String getProductTitleThird() {
        return productTileLinkThird.getText();
    }

    ;

    public void addToCartThird() {
        productTileButtonAddToCartThird.click();
    }


    public void addToWishlistThird() {
        productTileButtonAddToWishlistThird.click();
    }

    public void compareThird() {
        productTileButtonCompareThird.click();
    }

    public void clickOnImgForth() {
        productTileImgForth.click();
    }

    public void clickOnTitleForth() {
        productTileLinkForth.click();
    }

    public String getProductTitleForth() {
        return productTileLinkForth.getText();
    }

    ;

    public void addToCartForth() {
        productTileButtonAddToCartForth.click();
    }

    public void addToWishlistForth() {
        productTileButtonAddToWishlistForth.click();
    }

    public void compareForth() {
        productTileButtonCompareForth.click();
    }

    public int getCartQty() {
        List<String> stringList = new ArrayList<>();
        stringList = Arrays.asList(cartInfo.getText().split(" "));
        String firstElement = stringList.get(0);
  //      String[] line = cartInfo.getText().split(" ");
        return Integer.parseInt(firstElement);
    }

    public double getCartTotal() {
        String[] line = cartInfo.getText().split("\\$");
        return Double.parseDouble(line[1]);
    }

    public double getPriceOfFirst() {
        String[] wholeText = priceOfFirst.getText().split("\\$");
        String[] price = wholeText[1].split("\n");
        return Double.parseDouble(price[0]);
    }

    public double getPriceOfSecond() {
        String[] wholeText = priceOfSecond.getText().split("\\$");
        String[] price = wholeText[1].split("\n");
        return Double.parseDouble(price[0]);
    }

    public double getPriceOfThird() {
        String[] line = priceOfThird.getText().split("\\$");
        return Double.parseDouble(line[1]);
    }

    public double getPriceOfForth() {
        String[] line = priceOfForth.getText().split("\\$");
        return Double.parseDouble(line[1]);
    }

    public boolean isCompareMessageShown() {
        return compareMessage.isDisplayed();
    }

    public String getCompareMessage(){return compareMessage.getText();}

    public boolean isWishlistMessageShown() {
        return wishlistMessage.isDisplayed();
    }

    public boolean isFirstProductVisibleInMinicart() {
        return findElementBy(By.xpath(String.format
                ("//table[contains(@class, 'table-striped')]//descendant::*[text()='%s']",
                        productTileLinkFirst.getText()))).getText().equals(productTileLinkFirst.getText());
    }

    public boolean isSecondProductVisibleInMinicart() {
        return findElementBy(By.xpath(String.format
                ("//table[contains(@class, 'table-striped')]//descendant::*[text()='%s']",
                        productTileLinkSecond.getText()))).getText().equals(productTileLinkSecond.getText());
    }

//    public void scrollDown(WebElement element){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0], scrollIntoView()", element);
//    }
//
//    public void waitTillScriptIsLoaded(){
//        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
//    }
//
//    public void waitTillPageIsLoaded(){
//        driver.manage().timeouts().pageLoadedTimeout(40, TimeUnit.SECONDS);
//    }
//
//    public void explicitlyWait(){
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath")));
//    }


}

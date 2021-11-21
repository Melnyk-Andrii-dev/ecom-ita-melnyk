package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourStorePage extends BasePage {

    @FindBy(id = "common-home")
    WebElement yourStorePageIndicator;

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

    public void clickPrevOnMainSlider(){
        slideButtonPrev.click();
    }

    public void clickNextOnMainSlider(){
        slideButtonNext.click();
    }

    public void clickOnImgFirst(){
        productTileImgFirst.click();
    }

    public void clickOnTitleFirst(){
        productTileLinkFirst.click();
    }

    public void addToCartFirst(){
        productTileButtonAddToCartFirst.click();
    }

    public void addToWishlistFirst(){
        productTileButtonAddToWishlistFirst.click();
    }

    public void compareFirst(){
        productTileButtonCompareFirst.click();
    }

    public void clickOnImgSecond(){
        productTileImgSecond.click();
    }

    public void clickOnTitleSecond(){
        productTileLinkSecond.click();
    }

    public void addToCartSecond(){
        productTileButtonAddToCartSecond.click();
    }

    public void addToWishlistSecond(){
        productTileButtonAddToWishlistSecond.click();
    }

    public void compareSecond(){
        productTileButtonCompareSecond.click();
    }

    public void clickOnImgThird(){
        productTileImgThird.click();
    }

    public void clickOnTitleThird(){
        productTileLinkThird.click();
    }

    public void addToCartThird(){
        productTileButtonAddToCartThird.click();
    }


    public void addToWishlistThird(){
        productTileButtonAddToWishlistThird.click();
    }

    public void compareThird(){
        productTileButtonCompareThird.click();
    }

    public void clickOnImgForth(){
        productTileImgForth.click();
    }

    public void clickOnTitleForth(){
        productTileLinkForth.click();
    }

    public void addToCartForth(){
        productTileButtonAddToCartForth.click();
    }

    public void addToWishlistForth(){
        productTileButtonAddToWishlistForth.click();
    }

    public void compareForth(){
        productTileButtonCompareForth.click();
    }
}

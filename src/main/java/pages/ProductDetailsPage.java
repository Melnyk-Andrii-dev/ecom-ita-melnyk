package pages;

import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage{

    private final String productDetailsIndicator = "//div[@id='tab-description']";

    public boolean isProductDetailsPageOpened(){
       return findElementBy(By.xpath(productDetailsIndicator)).isDisplayed();
    }

}

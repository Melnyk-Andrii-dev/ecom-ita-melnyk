package pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {

    private static final String MYACCOUNT_INDICATOR = "//div[@id='content']//h2[contains(text(), 'My Account')]";

    public boolean isMyaccountPageOpened(){
       return  findElementBy(By.xpath(MYACCOUNT_INDICATOR)).isDisplayed();
    }
}

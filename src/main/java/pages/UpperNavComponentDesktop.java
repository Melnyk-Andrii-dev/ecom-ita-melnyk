package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpperNavComponentDesktop extends AbstractBasePage {

    private static final String DESKTOPS_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[text() = 'Desktops']";
    private static final String DESKTOPS_SUBCATEGORIES = "//ul[contains(@class, 'navbar-nav')]//a[contains(text(), 'Desktops')]//following-sibling::div[@class='dropdown-menu']//a[contains(text(), '%s')]";
    private static final String LAPTOPS_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[text() = 'Leptops']";
    private static final String LAPTOPS_SUBCATEGORIES = "//ul[contains(@class, 'navbar-nav')]//a[contains(text(), 'Laptops')]//following-sibling::div[@class='dropdown-menu']//a[contains(text(), '%s')]";
    private static final String COMPONENTS_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[text() = 'Components']";
    private static final String COMPONENTS_SUBCATEGORIES = "//ul[contains(@class, 'navbar-nav')]//a[contains(text(), 'Components')]//following-sibling::div[@class='dropdown-menu']//a[contains(text(), '%s')]";
    private static final String TABLETS_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[text() = 'Tablets']";
    private static final String SOFTWARE_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[text() = 'Software']";
    private static final String PHONES_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[text() = 'Phones']";
    private static final String CAMERAS_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[text() = 'Cameras']";
    private static final String MP3_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[text() = 'MP3']";
    private static final String MP3_SUBCATEGORIES = "//ul[contains(@class, 'navbar-nav')]//a[contains(text(), 'MP3')]//following-sibling::div[@class='dropdown-menu']//a[contains(text(), '%s')]";
    private static final String SHOWALL_SUBCATEGORIES_OF_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[@class='see-all' and contains(text(), '%s')]";

    public void clickDesktops(){
        findElementBy(By.xpath(DESKTOPS_CATEGORY)).click();
    }
    public void clickDesktopsSubcategory(String subcategory){
        findElementBy(By.xpath(String.format(DESKTOPS_SUBCATEGORIES, subcategory))).click();
    }

    public void clickLaptops(){
        findElementBy(By.xpath(LAPTOPS_CATEGORY)).click();
    }
    public void clickLaptopsSubcategory(String subcategory){
        findElementBy(By.xpath(String.format(LAPTOPS_SUBCATEGORIES, subcategory))).click();
    }

    public void clickComponents(){
        findElementBy(By.xpath(COMPONENTS_CATEGORY)).click();
    }
    public void clickComponentsSubcategory(String subcategory){
        findElementBy(By.xpath(String.format(COMPONENTS_SUBCATEGORIES, subcategory))).click();
    }

    public void clickTablets(){
        findElementBy(By.xpath(TABLETS_CATEGORY)).click();
    }

    public void clickSoftware(){
        findElementBy(By.xpath(SOFTWARE_CATEGORY)).click();
    }

    public void clickPhones(){
        findElementBy(By.xpath(PHONES_CATEGORY)).click();
    }

    public void clickCameras(){
        findElementBy(By.xpath(CAMERAS_CATEGORY)).click();
    }

    public void clickMP3(){
        findElementBy(By.xpath(MP3_CATEGORY)).click();
    }
    public void clickMP3Subcategory(String subcategory){
        findElementBy(By.xpath(String.format(MP3_SUBCATEGORIES, subcategory))).click();
    }

    public void clickShowSubcategory(String subcategory){
        findElementBy(By.xpath(String.format(SHOWALL_SUBCATEGORIES_OF_CATEGORY, subcategory))).click();
    }
}

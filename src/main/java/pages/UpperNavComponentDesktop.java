package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpperNavComponentDesktop extends AbstractBasePage {

    private static final String CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[contains(text(), '%s']";
    private static final String DESKTOPS_SUBCATEGORIES = "//a[contains(text(), 'Desktops')]//following-sibling::div[@class='dropdown-menu']//a[contains(text(), '%s')]";
    private static final String LAPTOPS_SUBCATEGORIES = "//a[contains(text(), 'Laptops')]//following-sibling::div[@class='dropdown-menu']//a[contains(text(), '%s')]";
    private static final String COMPONENTS_SUBCATEGORIES = "//a[contains(text(), 'Components')]//following-sibling::div[@class='dropdown-menu']//a[contains(text(), '%s')]";
    private static final String MP3_SUBCATEGORIES = "//a[contains(text(), 'MP3')]//following-sibling::div[@class='dropdown-menu']//a[contains(text(), '%s')]";
    private static final String SHOWALL_SUBCATEGORIES_OF_CATEGORY = "//ul[contains(@class, 'navbar-nav')]//a[@class='see-all' and contains(text(), '%s')]";

    public void clickOnCategory(String category){
        findElementBy(By.xpath(String.format(CATEGORY, category))).click();
    }

    public void clickDesktopsSubcategory(String subcategory){
        findElementBy(By.xpath(String.format(DESKTOPS_SUBCATEGORIES, subcategory))).click();
    }

    public void clickLaptopsSubcategory(String subcategory){
        findElementBy(By.xpath(String.format(LAPTOPS_SUBCATEGORIES, subcategory))).click();
    }

    public void clickComponentsSubcategory(String subcategory){
        findElementBy(By.xpath(String.format(COMPONENTS_SUBCATEGORIES, subcategory))).click();
    }

    public void clickMP3Subcategory(String subcategory){
        findElementBy(By.xpath(String.format(MP3_SUBCATEGORIES, subcategory))).click();
    }

    public void clickShowSubcategory(String subcategory){
        findElementBy(By.xpath(String.format(SHOWALL_SUBCATEGORIES_OF_CATEGORY, subcategory))).click();
    }
//    public void clickLaptops(){
//        findElementBy(By.xpath(LAPTOPS_CATEGORY)).click();
//    }
//
//    public void clickComponents(){
//        findElementBy(By.xpath(COMPONENTS_CATEGORY)).click();
//    }
//
//    public void clickTablets(){
//        findElementBy(By.xpath(TABLETS_CATEGORY)).click();
//    }
//
//    public void clickSoftware(){
//        findElementBy(By.xpath(SOFTWARE_CATEGORY)).click();
//    }
//
//    public void clickPhones(){
//        findElementBy(By.xpath(PHONES_CATEGORY)).click();
//    }
//
//    public void clickCameras(){
//        findElementBy(By.xpath(CAMERAS_CATEGORY)).click();
//    }
//
//    public void clickMP3(){
//        findElementBy(By.xpath(MP3_CATEGORY)).click();
//    }

}

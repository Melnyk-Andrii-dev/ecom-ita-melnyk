package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractBasePage {

    @Getter
    private static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public WebElement waitForVisibilityOfElement(WebElement locator) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(locator));
    }

    public WebElement findElementBy(By by) {
        return waitForVisibilityOfElement(driver.findElement(by));
    }

    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}

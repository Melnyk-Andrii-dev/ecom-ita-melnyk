package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractBasePage {

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriverThreadLocal(WebDriver webDriver){
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public static WebDriver getDriverThreadLocal(){
        return DRIVER_THREAD_LOCAL.get();
    }

//    @Getter
//    private static WebDriver driver;
//
//    public static void setDriver(WebDriver webDriver) {
//        driver = webDriver;
//    }



    public WebElement waitForVisibilityOfElement(WebElement locator) {
        return new WebDriverWait(getDriverThreadLocal(), 10).until(ExpectedConditions.visibilityOf(locator));
    }

    public WebElement findElementBy(By by) {
        return waitForVisibilityOfElement(getDriverThreadLocal().findElement(by));
    }

    public void implicitlyWait(){
        getDriverThreadLocal().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}

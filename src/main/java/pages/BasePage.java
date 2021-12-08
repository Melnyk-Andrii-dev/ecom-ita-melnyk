package pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

@Getter
@Accessors(fluent = true)
public class BasePage extends AbstractBasePage {

    private final String YOURSTOREPAGE_LINK = "//div[@id='logo']//a[contains(@href, 'common/home')]";

    @Getter
    @Accessors
    protected HeaderComponent headerComponent = new HeaderComponent();
    @Getter
    @Accessors
    protected UpperNavComponentDesktop upperNavComponentDesktop = new UpperNavComponentDesktop();

    public void clickYourStorePage(){
        findElementBy(By.xpath(YOURSTOREPAGE_LINK)).click();
    }


}

package pages;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class BasePage extends AbstractBasePage {
    @Getter
    @Accessors
    protected HeaderComponent headerComponent = new HeaderComponent();
    @Getter
    @Accessors
    protected UpperNavComponentDesktop upperNavComponentDesktop = new UpperNavComponentDesktop();

}

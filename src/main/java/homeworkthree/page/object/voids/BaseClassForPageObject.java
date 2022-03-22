package homeworkthree.page.object.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassForPageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseClassForPageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}

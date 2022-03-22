package homeworkthree.page.object.voids;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectComposite extends BaseClassForPageObject {
    public PageObjectComposite(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "navbar-right")
    private WebElement loginButton;

    @FindBy(id = "name")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement submitButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")
    private List<WebElement> headerMenuElements;

    public void login(String name, String password) {
        loginButton.click();
        userField.sendKeys(name);
        this.passwordField.sendKeys(password);
        submitButton.click();
    }

    public String returnTextOfElement() {

        String text;
        text = userName.getText();
        return text;
    }

    public List<String> getHeaderMenuElements() {
        return headerMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

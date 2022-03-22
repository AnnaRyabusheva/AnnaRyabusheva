package homeworkthree.page.object.voids;

import homeworkthree.BaseClass3;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends BaseClass3 {
    @FindBy(css = "ul.uui-navigation > li a.dropdown-toggle")
    private WebElement serviceButton;

    @FindBy(xpath = "//ul[@class=\"dropdown-menu\"]//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;

    @FindBy(xpath = "//div[@class=\"support-title\"]")
    private WebElement differentPageOpen;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[1]")
    private WebElement verifyElementString;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxList;

    @FindBy(className = "label-radio")
    private List<WebElement> radioBoxList;

    @FindBy(xpath = "//div[@class=\"colors\"]//select[@class=\"uui-form-element\"]")
    private WebElement selectElem;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void differentPageOpen() {
        serviceButton.click();
        differentElementsButton.click();
    }

    public String returnTextOfTitle() {

        String text;
        text = differentPageOpen.getText();
        return text;
    }

    public void clickForLabelCheckbox(String checkBox) {
        for (WebElement elem : checkBoxList) {
            if (elem.getText().equals(checkBox)) {
                elem.click();
                break;
            }
        }
    }

    public String returnLastLogString() {
        return verifyElementString.getText();
    }

    public void clickForLabelRadio(String checkRadioBox) {
        for (WebElement elem : radioBoxList) {
            if (elem.getText().equals(checkRadioBox)) {
                elem.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        Select selectColor = new Select(selectElem);
        selectColor.selectByVisibleText(color);
    }
}

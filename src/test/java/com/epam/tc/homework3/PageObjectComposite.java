package com.epam.tc.homework3;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectComposite extends BaseClass3 {
    public PageObjectComposite(WebDriver driver) {
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

    @FindBy(css = "ul.uui-navigation > li")
    private List<WebElement> listOfHeaderMenuForHW3;

    public void login(String name, String password) {
        loginButton.click();
        userField.sendKeys(name);
        this.passwordField.sendKeys(password);
        submitButton.click();
    }
}

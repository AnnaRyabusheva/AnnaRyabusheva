package com.epam.tc.homework3;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeWorkIndexPage extends BaseClass3 {
    public HomeWorkIndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
//    PageObjectComposite pageObjectComposite= new PageObjectComposite();
//    @FindBy(className = "navbar-right")
//    private WebElement loginButton;
//
//    @FindBy(id = "name")
//    private WebElement userField;
//
//    @FindBy(id = "password")
//    private WebElement passwordField;
//
//    @FindBy(id = "login-button")
//    private WebElement submitButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = "ul.uui-navigation > li")
    private List<WebElement> listOfHeaderMenuForHW3;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")
    private List<WebElement> headerMenuElements;

    @FindBy(css = "div.benefits span.benefit-txt")
    private List<WebElement> listOfText;

    @FindBy(css = "ul.sidebar-menu >li > a > span")
    private List<WebElement> listOfLeftMenu;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(className = "icon-practise")
    private WebElement image;

    @FindBy(className = "icon-custom")
    private WebElement imageCustom;

    @FindBy(className = "icon-multi")
    private WebElement imageMulti;

    @FindBy(className = "icon-base")
    private WebElement imageBase;

    public String returnTextOfElement() {

        String text;
        text = userName.getText();
        return text;
    }

    public boolean isIconPracticeImageDisplayed() {
        return image.isDisplayed();
    }

    public boolean isIconCustomImageDisplayed() {
        return imageCustom.isDisplayed();
    }

    public boolean isIconMultiImageDisplayed() {
        return imageMulti.isDisplayed();
    }

    public boolean isIconBaseImageDisplayed() {
        return imageBase.isDisplayed();
    }

    public boolean isFrameButtonDisplayed() {
        return frameButton.isDisplayed();
    }

//    public void login(String name, String password) {
//        loginButton.click();
//        userField.sendKeys(name);
//        this.passwordField.sendKeys(password);
//        submitButton.click();
//    }

    public List<String> getHeaderMenuElements() {
        return headerMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTextBelowImage() {
        return listOfText.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getLeftMenuElements() {
        return listOfLeftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

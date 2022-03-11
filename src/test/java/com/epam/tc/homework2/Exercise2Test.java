package com.epam.tc.homework2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseClass {

    //    public void clickForLabelCheckbox(String checkBox) {
    //        List<WebElement> checkBoxList = driver.findElements(By.className("label-checkbox"));
    //        for (WebElement elem : checkBoxList) {
    //            if (elem.getText().equals(checkBox)) {
    //                elem.click();
    //                break;
    //            }
    //        }
    //    }
    //
    //    public void clickForLabelRadio(String checkRadioBox) {
    //        List<WebElement> radioBoxList = driver.findElements(By.className("label-radio"));
    //        for (WebElement elem : radioBoxList) {
    //            if (elem.getText().equals(checkRadioBox)) {
    //                elem.click();
    //                break;
    //            }
    //        }
    //    }

    @Test
    public void testOpenPage() {
        String lastLog;

        //1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html ");

        //2. Assert Browser title "Home Page"
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");

        // Find login's form and click
        driver.findElements(By.className("navbar-right")).get(0).click();

        // 3.Perform login
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");

        // Click to bottom Enter
        driver.findElement(By.id("login-button")).click();

        // 4. Assert Username is logging
        String txtUserName = driver.findElement(By.id("user-name")).getText();
        softly.assertThat(txtUserName).isEqualTo("ROMAN IOVLEV");

        // 5.Open through the header menu Service -> Different Elements Page
        driver.findElement(By.cssSelector("ul.uui-navigation > li a.dropdown-toggle")).click();

        driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[contains(text(),'Different elements')]"))
              .click();

        String differentPageOpen = driver.findElement(By.xpath("//div[@class=\"support-title\"]")).getText();
        softly.assertThat(differentPageOpen).isEqualTo("Support");

        // 6.Select checkboxes Water

        clickForLabelCheckbox("Water");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("Water: condition changed to true");

        // 6.Select checkboxes Wind

        clickForLabelCheckbox("Wind");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("Wind: condition changed to true");

        // 7.Select radio Selen Element is checked

        clickForLabelRadio("Selen");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("metal: value changed to Selen");

        // 8.Select in dropdown Yellow Element is selected

        WebElement selectElem = driver.findElement(By.xpath("//div[@class=\"colors\"]"
            + "//select[@class=\"uui-form-element\"]"));
        Select selectColor = new Select(selectElem);
        selectColor.selectByVisibleText("Yellow");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("Colors: value changed to Yellow");
        // 9.Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // for radio button there is a log row and value is corresponded to the status of radio button
        // for dropdown there is a log row and value is corresponded to the selected value.

        clickForLabelCheckbox("Earth");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("Earth: condition changed to true");

        clickForLabelCheckbox("Fire");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("Fire: condition changed to true");

        clickForLabelRadio("Gold");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("metal: value changed to Gold");

        clickForLabelRadio("Silver");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("metal: value changed to Silver");

        clickForLabelRadio("Bronze");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("metal: value changed to Bronze");

        WebElement selectColorR = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select"));
        Select selectColorRed = new Select(selectColorR);
        selectColorRed.selectByVisibleText("Red");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("Colors: value changed to Red");

        WebElement selectColorG = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select"));
        Select selectColorGreen = new Select(selectColorG);
        selectColorGreen.selectByVisibleText("Green");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("Colors: value changed to Green");

        WebElement selectColorB = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select"));
        Select selectColorBlue = new Select(selectColorB);
        selectColorBlue.selectByVisibleText("Blue");
        lastLog = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[1]"))
                        .getText();
        softly.assertThat(lastLog).contains("Colors: value changed to Blue");
        softly.assertAll();
    }
}


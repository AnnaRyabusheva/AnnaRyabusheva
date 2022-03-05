package com.epam.tc.homework2;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseClassForExercise2 {

    @Test
    public void testOpenPage() {
        SoftAssertions softly = new SoftAssertions();
        driver.manage().window().maximize();

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
        driver.findElement(By.xpath("//label[@class=\"label-checkbox\"][1]/input")).click();
        String verifyWater =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyWater).contains("Water: condition changed to true");

        // 6.Select checkboxes Wind
        driver.findElement(By.xpath("//label[@class=\"label-checkbox\"][3]/input")).click();
        String verifyWind =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyWind).contains("Wind: condition changed to true");

        // 7.Select radio Selen Element is checked
        driver.findElement(By.xpath("//label[@class=\"label-radio\"][4]/input")).click();
        String verifySelen =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifySelen).contains("metal: value changed to Selen");

        // 8.Select in dropdown Yellow Element is selected

        WebElement selectElem = driver.findElement(By.xpath("//div[@class=\"colors\"]"
            + "//select[@class=\"uui-form-element\"]"));
        Select selectColor = new Select(selectElem);
        selectColor.selectByVisibleText("Yellow");
        String verifyColor =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyColor).contains("Colors: value changed to Yellow");
        // 9.Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // for radio button there is a log row and value is corresponded to the status of radio button
        // for dropdown there is a log row and value is corresponded to the selected value.
        driver.findElement(By.xpath("//label[@class=\"label-checkbox\"][2]/input")).click();
        String verifyEarth =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyEarth).contains("Earth: condition changed to true");
        driver.findElement(By.xpath("//label[@class=\"label-checkbox\"][4]/input")).click();
        String verifyFire =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyFire).contains("Fire: condition changed to true");
        driver.findElement(By.xpath("//label[@class=\"label-radio\"][1]/input")).click();
        String verifyGold =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyGold).contains("metal: value changed to Gold");
        driver.findElement(By.xpath("//label[@class=\"label-radio\"][2]/input")).click();
        String verifySilver =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifySilver).contains("metal: value changed to Silver");
        driver.findElement(By.xpath("//label[@class=\"label-radio\"][3]/input")).click();
        String verifyBronze =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyBronze).contains("metal: value changed to Bronze");
        WebElement selectColorR = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select"));
        Select selectColorRed = new Select(selectColorR);
        selectColorRed.selectByVisibleText("Red");
        String verifyColorRed =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyColorRed).contains("Colors: value changed to Red");
        WebElement selectColorG = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select"));
        Select selectColorGreen = new Select(selectColorG);
        selectColorGreen.selectByVisibleText("Green");
        String verifyColorGreen =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyColorGreen).contains("Colors: value changed to Green");
        WebElement selectColorB = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select"));
        Select selectColorBlue = new Select(selectColorB);
        selectColorBlue.selectByVisibleText("Blue");
        String verifyColorBlue =
            driver.findElement(By.xpath("//div[@name=\"log-sidebar\"]//ul[@class=\"panel-body-list logs\"]/li[1]"))
                  .getText();
        softly.assertThat(verifyColorBlue).contains("Colors: value changed to Blue");
        softly.assertAll();
    }
}



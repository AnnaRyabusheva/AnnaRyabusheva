package com.epam.tc.homework2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.DURATION;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise1Test {

    private WebDriver driver;

    @BeforeMethod
    // 12.Close Browser

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenPage() {
        SoftAssertions softly = new SoftAssertions();

        //
        driver.manage().window().maximize();
        // 1.  Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html ");
        // 2. Assert Browser title "Home Page"
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");
        //   Find login's form and click
        driver.findElements(By.className("navbar-right")).get(0).click();
        // 3. Perform login
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");

        // Click to bottom Enter
        driver.findElement(By.id("login-button")).click();
        // 4.Assert Username is logging
        String txtUserName = driver.findElement(By.id("user-name")).getText();
        softly.assertThat(txtUserName).isEqualTo("ROMAN IOVLEV");
        // 5.Assert that there are 4 items on the header section are displayed,
        // and they have proper texts( element= Home)

        String fieldHome = driver.findElement(
            By.xpath("//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]//*[contains(text(),'Home')]")).getText();
        softly.assertThat(fieldHome).isEqualTo("HOME");

        // 5. Assert that there are 4 items on the header section are displayed,
        // and they have proper texts ( element = CONTACT FORM )

        String fieldContactForm = driver.findElement(
                                            By.xpath("//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]"
                                                + "//*[contains(text(),'Contact form')]"))
                                        .getText();
        softly.assertThat(fieldContactForm).isEqualTo("CONTACT FORM");

        // 5. Assert that there are 4 items on the header section are displayed,
        // and they have proper texts ( element = SERVICE )

        String fieldService = driver.findElement(
            By.xpath("//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]//*[contains(text(),'Service')]")).getText();
        softly.assertThat(fieldService).isEqualTo("SERVICE");
        // 5.Assert that there are 4 items on the header section are displayed,
        // and they have proper texts ( element = METALS & COLORS )
        // "METALS & COLORS");
        String fieldMetalColor = driver.findElement(
                                           By.xpath("//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]"
                                               + "//*[contains(text(),'Metals & Colors')]"))
                                       .getText();
        softly.assertThat(fieldMetalColor).isEqualTo("METALS & COLORS");

        // 6.Assert that there are 4 images on the Index Page, and they are displayed

        boolean image = driver.findElement(By.className("icon-practise")).isDisplayed();
        softly.assertThat(image).isTrue();
        boolean imageCustom = driver.findElement(By.className("icon-custom")).isDisplayed();
        softly.assertThat(imageCustom).isTrue();
        boolean imageBenefit = driver.findElement(By.className("icon-multi")).isDisplayed();
        softly.assertThat(imageBenefit).isTrue();
        boolean imageTxt = driver.findElement(By.className("icon-base")).isDisplayed();
        softly.assertThat(imageTxt).isTrue();
        // 7.Assert that there are 4 texts on the Index Page under icons,
        // and they have proper text,4 texts below of each image
        // Texts are displayed and equal to expected
        List<WebElement> itemsTR =
            driver.findElements(By.xpath("//div[@class=\"row clerafix benefits\"]/div[@class=\"col-sm-3\"]"));
        int itemTR1 = itemsTR.size();
        System.out.println(itemTR1);
        List<WebElement> lst =
            driver.findElements(By.xpath("//div[@class=\"row clerafix benefits\"]/div[@class=\"col-sm-3\"]"));
        List<String> strings = new ArrayList<>();
        for (WebElement e : lst) {
            strings.add(e.getText());
        }
        List<String> list = new ArrayList<>();
        list.add("To include good practices\nand ideas from successful\nEPAM project");
        list.add("To be flexible and\ncustomizable");
        list.add("To be multiplatform");
        list.add("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        boolean b = list.containsAll(strings);
        softly.assertThat(b).isTrue();
        // 8.Assert that there is the iframe with “Frame Button” exist
        driver.switchTo().frame(driver.findElement(By.id("frame")));
        // 9.Switch to the iframe and check that there is “Frame Button” in the iframe
        boolean buttonIsExist = driver.findElement(By.xpath("//*[@id=\"frame-button\"]")).isDisplayed();
        softly.assertThat(buttonIsExist).isTrue();
        // 10.Switch to original window back
        driver.switchTo().defaultContent();

        // 11.Assert that there are 5 items in the Left Section are displayed, and they have proper text
        boolean leftHome = driver.findElement(By.xpath(
                                     "//div[@name=\"navigation-sidebar\"]"
                                         + "//ul[@class=\"sidebar-menu left\"]//*[contains(text(),'Home')]"))
                                 .isDisplayed();
        softly.assertThat(leftHome).isTrue();
        String leftHomeContTxt = driver.findElement(By.xpath(
                                           "//div[@name=\"navigation-sidebar\"]"
                                               + "//ul[@class=\"sidebar-menu left\"]//*[contains(text(),'Home')]"))
                                       .getText();
        softly.assertThat(leftHomeContTxt).isEqualTo("Home");
        boolean leftContactForm = driver.findElement(By.xpath(
                                            "//div[@name=\"navigation-sidebar\"]"
                                                + "//ul[@class=\"sidebar-menu left\"]"
                                                + "//*[contains(text(),'Contact form')]"))
                                        .isDisplayed();
        softly.assertThat(leftContactForm).isTrue();
        String leftContactFormTxt = driver.findElement(By.xpath(
                                              "//div[@name=\"navigation-sidebar\"]"
                                                  + "//ul[@class=\"sidebar-menu left\"]"
                                                  + "//*[contains(text(),'Contact form')]"))
                                          .getText();
        softly.assertThat(leftContactFormTxt).isEqualTo("Contact form");
        boolean leftService = driver.findElement(By.xpath(
                                        "//div[@name=\"navigation-sidebar\"]"
                                            + "//ul[@class=\"sidebar-menu left\"]//*[contains(text(),'Service')]"))
                                    .isDisplayed();
        softly.assertThat(leftService).isTrue();
        String leftServiceConTxt = driver.findElement(By.xpath(
                                             "//div[@name=\"navigation-sidebar\"]"
                                                 + "//ul[@class=\"sidebar-menu left\"]"
                                                 + "//*[contains(text(),'Service')]"))
                                         .getText();
        softly.assertThat(leftServiceConTxt).isEqualTo("Service");
        boolean leftMetalColor = driver.findElement(By.xpath(
                                           "//div[@name=\"navigation-sidebar\"]"
                                               + "//ul[@class=\"sidebar-menu left\"]"
                                               + "//*[contains(text(),'Metals & Colors')]"))
                                       .isDisplayed();
        softly.assertThat(leftMetalColor).isTrue();
        String leftMetalColConTxt = driver.findElement(By.xpath(
                                              "//div[@name=\"navigation-sidebar\"]"
                                                  + "//ul[@class=\"sidebar-menu left\"]"
                                                  + "//*[contains(text(),'Metals & Colors')]"))
                                          .getText();
        softly.assertThat(leftMetalColConTxt).isEqualTo("Metals & Colors");
        boolean leftElementsPacks = driver.findElement(By.xpath(
                                              "//div[@name=\"navigation-sidebar\"]"
                                                  + "//ul[@class=\"sidebar-menu left\"]"
                                                  + "//*[contains(text(),'Elements packs')]"))
                                          .isDisplayed();
        softly.assertThat(leftElementsPacks).isTrue();
        String leftElementsPConTxt = driver.findElement(By.xpath(
                                               "//div[@name=\"navigation-sidebar\"]"
                                                   + "//ul[@class=\"sidebar-menu left\"]"
                                                   + "//*[contains(text(),'Elements packs')]"))
                                           .getText();
        softly.assertThat(leftElementsPConTxt).isEqualTo("Elements packs");
        softly.assertAll();
    }
}



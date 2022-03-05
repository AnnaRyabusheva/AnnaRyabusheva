package com.epam.tc.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseClassForExercise2 {

    @Test
    public void testOpenPage() {

        List<String> listOfHeaderMenu = new ArrayList<>();
        listOfHeaderMenu.add("HOME");
        listOfHeaderMenu.add("CONTACT FORM");
        listOfHeaderMenu.add("SERVICE");
        listOfHeaderMenu.add("METALS & COLORS");

        List<String> listOfTextBelowImage = new ArrayList<>();
        listOfTextBelowImage.add("To include good practices\nand ideas from successful\nEPAM project");
        listOfTextBelowImage.add("To be flexible and\ncustomizable");
        listOfTextBelowImage.add("To be multiplatform");
        listOfTextBelowImage.add(
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        List<String> listOfLeftMenu = new ArrayList<>();
        listOfLeftMenu.add("Home");
        listOfLeftMenu.add("Contact form");
        listOfLeftMenu.add("Service");
        listOfLeftMenu.add("Metals & Colors");
        listOfLeftMenu.add("Elements packs");

        SoftAssertions softly = new SoftAssertions();
        // 1.  Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

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
        List<WebElement> headerMenuElements = driver.findElements(By.cssSelector("ul.uui-navigation > li"));
        List<String> textsHeaderMenuElements =
            headerMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
        softly.assertThat(textsHeaderMenuElements).hasSameElementsAs(listOfHeaderMenu);

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
        List<WebElement> imageText = driver.findElements(By.cssSelector("div.benefits span.benefit-txt"));
        List<String> textsBelowImage =
            imageText.stream().map(WebElement::getText).collect(Collectors.toList());
        softly.assertThat(textsBelowImage).hasSameElementsAs(listOfTextBelowImage);

        // 8.Assert that there is the iframe with “Frame Button” exist
        driver.switchTo().frame(driver.findElement(By.id("frame")));

        // 9.Switch to the iframe and check that there is “Frame Button” in the iframe
        boolean buttonIsExist = driver.findElement(By.id("frame-button")).isDisplayed();
        softly.assertThat(buttonIsExist).isTrue();

        // 10.Switch to original window back
        driver.switchTo().defaultContent();

        // 11.Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> leftMenuElements = driver.findElements(By.cssSelector("ul.sidebar-menu >li span"));
        List<String> textsLeftMenuElements =
            leftMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
        softly.assertThat(textsLeftMenuElements).hasSameElementsAs(listOfLeftMenu);
    }
}



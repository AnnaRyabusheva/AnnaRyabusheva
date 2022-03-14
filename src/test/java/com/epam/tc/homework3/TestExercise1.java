package com.epam.tc.homework3;

import com.epam.tc.homework3.page.object.voids.HomeWorkIndexPage;
import com.epam.tc.homework3.page.object.voids.PageObjectComposite;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestExercise1 extends BaseClass3 {

    @Test
    public void testExercise() {
        // 1.  Open test site by URL

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
        PageObjectComposite pageObjectComposite = new PageObjectComposite(driver);

        // 2. Assert Browser title "Home Page"
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");

        // 3.Perform login
        pageObjectComposite.login("Roman", "Jdi1234");

        // 4.Assert Username is logging

        softly.assertThat(pageObjectComposite.returnTextOfElement()).isEqualTo("ROMAN IOVLEV");

        // 5.Assert that there are 4 items on the header section are displayed,
        // and they have proper texts

        softly.assertThat(pageObjectComposite.getHeaderMenuElements()).hasSameElementsAs(listOfHeaderMenu);

        // 6.Assert that there are 4 images on the Index Page, and they are displayed
        HomeWorkIndexPage homeWorkIndexPage = new HomeWorkIndexPage(driver);

        softly.assertThat(homeWorkIndexPage.isIconPracticeImageDisplayed()).isTrue();

        softly.assertThat(homeWorkIndexPage.isIconCustomImageDisplayed()).isTrue();

        softly.assertThat(homeWorkIndexPage.isIconCustomImageDisplayed()).isTrue();

        softly.assertThat(homeWorkIndexPage.isIconMultiImageDisplayed()).isTrue();

        softly.assertThat(homeWorkIndexPage.isIconBaseImageDisplayed()).isTrue();
        // 7.Assert that there are 4 texts on the Index Page under icons,
        // and they have proper text,4 texts below of each image
        // Texts are displayed and equal to expected

        softly.assertThat(homeWorkIndexPage.getTextBelowImage()).hasSameElementsAs(listOfTextBelowImage);

        // 8.Assert that there is the iframe with “Frame Button” exist
        driver.switchTo().frame(driver.findElement(By.id("frame")));

        // 9.Switch to the iframe and check that there is “Frame Button” in the iframe
        softly.assertThat(homeWorkIndexPage.isFrameButtonDisplayed()).isTrue();
        // 10.Switch to original window back
        driver.switchTo().defaultContent();
        // 11.Assert that there are 5 items in the Left Section are displayed, and they have proper text

        softly.assertThat(homeWorkIndexPage.getLeftMenuElements()).hasSameElementsAs(listOfLeftMenu);

        // 12.Close Browser
        softly.assertAll();

    }
}

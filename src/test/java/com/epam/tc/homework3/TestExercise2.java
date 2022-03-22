package com.epam.tc.homework3;

import homeworkthree.page.object.voids.DifferentElementsPage;
import homeworkthree.page.object.voids.PageObjectComposite;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class TestExercise2 extends BaseClass3 {

    @Test
    public void testExerciseForHomeWork() {

        PageObjectComposite pageObjectComposite = new PageObjectComposite(driver, wait);

        SoftAssertions softly = new SoftAssertions();
        //1. Open test site by URL

        //2. Assert Browser title "Home Page"
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");

        // 3.Perform login
        pageObjectComposite.login("Roman", "Jdi1234");

        // 4. Assert Username is logging
        pageObjectComposite.returnTextOfElement();
        softly.assertThat(pageObjectComposite.returnTextOfElement()).isEqualTo("ROMAN IOVLEV");

        // 5.Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver, wait);
        differentElementsPage.differentPageOpen();
        differentElementsPage.returnTextOfTitle();
        softly.assertThat(differentElementsPage.returnTextOfTitle()).isEqualTo("Support");

        // 6.Select checkboxes Water
        differentElementsPage.clickForLabelCheckbox("Water");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("Water: condition changed to true");

        // 6.Select checkboxes Wind
        differentElementsPage.clickForLabelCheckbox("Wind");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("Wind: condition changed to true");

        // 7.Select radio Selen Element is checked
        differentElementsPage.clickForLabelRadio("Selen");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("metal: value changed to Selen");

        // 8.Select in dropdown Yellow Element is selected
        differentElementsPage.selectColor("Yellow");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("Colors: value changed to Yellow");

        // 9.Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // for radio button there is a log row and value is corresponded to the status of radio button
        // for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.clickForLabelCheckbox("Earth");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("Earth: condition changed to true");

        differentElementsPage.clickForLabelCheckbox("Fire");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("Fire: condition changed to true");

        differentElementsPage.clickForLabelRadio("Gold");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("metal: value changed to Gold");

        differentElementsPage.clickForLabelRadio("Silver");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("metal: value changed to Silver");

        differentElementsPage.clickForLabelRadio("Bronze");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("metal: value changed to Bronze");

        differentElementsPage.selectColor("Red");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("Colors: value changed to Red");

        differentElementsPage.selectColor("Green");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("Colors: value changed to Green");

        differentElementsPage.selectColor("Blue");
        softly.assertThat(differentElementsPage.returnLastLogString()).contains("Colors: value changed to Blue");

        softly.assertAll();
    }
}


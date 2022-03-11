package com.epam.tc.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().window().maximize();
    }

    SoftAssertions softly = new SoftAssertions();

    // 12.Close Browser
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void clickForLabelCheckbox(String checkBox) {
        List<WebElement> checkBoxList = driver.findElements(By.className("label-checkbox"));
        for (WebElement elem : checkBoxList) {
            if (elem.getText().equals(checkBox)) {
                elem.click();
                break;
            }
        }
    }

    public void clickForLabelRadio(String checkRadioBox) {
        List<WebElement> radioBoxList = driver.findElements(By.className("label-radio"));
        for (WebElement elem : radioBoxList) {
            if (elem.getText().equals(checkRadioBox)) {
                elem.click();
                break;
            }
        }
    }


}


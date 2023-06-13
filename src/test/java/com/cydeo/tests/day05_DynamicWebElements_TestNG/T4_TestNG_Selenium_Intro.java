package com.cydeo.tests.day05_DynamicWebElements_TestNG;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_TestNG_Selenium_Intro {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
         driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cydeo.com");
    }
    @Test
    public void test1_cydeo_title_verification(){



      String actualTitle = driver.getTitle();
      String expectedTitle = "Cydeo";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
/*
TC #4: Cydeo Title Verification
1.Open Chrome browser
2.Go to https://www.cydeo.com
3.Verify title:
Expected: Cydeo
 */
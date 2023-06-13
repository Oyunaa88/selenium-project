package com.cydeo.tests.day05_DynamicWebElements_TestNG;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T7_selectState_dropdown {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void selectStateDropdownVerification(){
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectState.selectByValue("IL");
        selectState.selectByValue("VA");
        selectState.selectByVisibleText("California");
        String actualSelectedState = selectState.getFirstSelectedOption().getText();
        String expectedSelectedState = "California";
        Assert.assertEquals(actualSelectedState,expectedSelectedState);
    }
}
/*
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */
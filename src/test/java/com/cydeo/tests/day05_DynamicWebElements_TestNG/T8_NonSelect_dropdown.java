package com.cydeo.tests.day05_DynamicWebElements_TestNG;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T8_NonSelect_dropdown {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void selectStateDropdownVerification(){
      //  WebElement dropdownLink = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        WebElement websiteDropdown = driver.findElement(By.linkText("Dropdown link"));
        websiteDropdown.click();

        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        //Thread.sleep(1000);
        facebookLink.click();
        //5. Verify title is  "Facebook - log in or sign up"
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Titles are not equal!");

    }
}
/*
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
 */
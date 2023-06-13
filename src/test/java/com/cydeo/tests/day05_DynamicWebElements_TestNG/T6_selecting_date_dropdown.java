package com.cydeo.tests.day05_DynamicWebElements_TestNG;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T6_selecting_date_dropdown {
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//3. Select “December 1st, 1933” and verify it is selected.
//Select year using : visible text
//Select month using : value attribute
//Select day using : index number

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void selectDateDropdownVerification(){

        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectYear.selectByVisibleText("1933");
       Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
      selectMonth.selectByValue("11");
Select selectDate = new Select(driver.findElement(By.xpath("//select[@id='day']")));
selectDate.selectByIndex(0);


    }

}

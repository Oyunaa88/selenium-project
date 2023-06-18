package com.cydeo.tests.review.week3;

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

public class RegistrationForm {

    WebDriver driver;
    Select selectDepartment;
    Select selectJobTitle;


    @BeforeMethod
    public void setup(){
        // 1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

    }


    @Test(priority = 1 )
    public void registrationFormPageTest(){

//        // 1. Open Chrome browser
//
//        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        // 2. Go to https://practice.cydeo.com/registration_form
//        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected:
        // Expected: "Registration Form"

        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration Form";

        Assert.assertTrue(actualTitle.equals(expectedTitle),"Title verification is failed!");

    }

    @Test (priority = 2)
    public void registrationFillingOutTest() throws InterruptedException {

        // 3. Enter First name: "John"
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("John");

        // 4. Enter Last name: "Smith"
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='last name']"));
        lastName.sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='username']"));
        username.sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"

        // 7. Enter password: "John1234"
        // 8. Enter Phone number: "123-456-7890"


        // 9. Click to "Male" from Gender
        WebElement maleRadioBtn1 = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleRadioBtn2 = driver.findElement(By.xpath("//input[@value='male']"));
        maleRadioBtn1.click();
        Assert.assertTrue(maleRadioBtn1.isSelected());

        Thread.sleep(3000);

        // 10. Enter Date of birth "01/28/1990"
        // 11. Select "Department of Engineering" from Department/Office dropdown
        selectDepartment = new Select(driver.findElement(By.name("department")));
        System.out.println("selectDepartment.getFirstSelectedOption() = " + selectDepartment.getFirstSelectedOption().getText());

        // selectDepartment.selectByIndex(1);
        // selectDepartment.selectByValue("DE");
        selectDepartment.selectByVisibleText("Department of Engineering");

        System.out.println("selectDepartment.getFirstSelectedOption() = " + selectDepartment.getFirstSelectedOption().getText());

        Thread.sleep(3000);

        // 12. Select "SDET" from Job title dropdown
        selectJobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        System.out.println("selectJobTitle.getFirstSelectedOption().getText() = " + selectJobTitle.getFirstSelectedOption().getText());
        selectJobTitle.selectByIndex(4);
        // selectJobTitle.selectByVisibleText("SDET");
        System.out.println("selectJobTitle.getFirstSelectedOption().getText() = " + selectJobTitle.getFirstSelectedOption().getText());

        // 13. Click to "Java" from languages
        // 14. Click to "Sign up" button
        // 15. Verify text displayed on page
        //     Expected: "Well done!"

    }


    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}

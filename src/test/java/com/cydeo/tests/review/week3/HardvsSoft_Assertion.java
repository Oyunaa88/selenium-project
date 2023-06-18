package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardvsSoft_Assertion {

    //1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/login
    // 3. Enter username: "tomsmith"
    // 4. Enter password: "SuperSecretPassword"
    // 5. Click to Login button
    // 6. Verify text displayed on page
    //    Expected: "You logged into a secure area!"

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/login");
    }

    @Test
    public void login_test_with_hard_assertion(){

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement loginBtn1 = driver.findElement(By.id("wooden_spoon"));
        loginBtn1.click();

        Assert.assertTrue(driver.getTitle().equals("Secure Are"));

        WebElement resultText = driver.findElement(By.xpath("//div[normalize-space(text()) ='You logged into a secure area!']"));
        String actualResulText = resultText.getText();
        String expectedResultText = "You logged into a secure area!!!";

        System.out.println("resultText.getText() = " + resultText.getText());

        Assert.assertTrue(actualResulText.contains(expectedResultText));



    }

    @Test
    public void login_test_with_soft_assertion(){

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement loginBtn1 = driver.findElement(By.id("wooden_spoon"));
        loginBtn1.click();

        SoftAssert  softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().equals("Secure Area"));

        WebElement resultText = driver.findElement(By.xpath("//div[normalize-space(text()) ='You logged into a secure area!']"));
        String actualResulText = resultText.getText();
        String expectedResultText = "You logged into a secure area!!!";

        System.out.println("resultText.getText() = " + resultText.getText());

        softAssert.assertTrue(actualResulText.contains(expectedResultText));
        softAssert.assertAll(); // executing all assertions
    }
}

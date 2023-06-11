package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_LoginPage_Practice {

    public static void main(String[] args) {
        // 1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        WebElement userName= driver.findElement(By.xpath("//input[@name='username']"));
        // driver.findElement(By.name='username')
        userName.sendKeys("tomsmith");

        // 4. Enter password: "SuperSecretPassword"
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("SuperSecretPassword");
        // 5. Click to Login button

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        loginButton.click();

        // 6. Verify text displayed on page
        WebElement resultText1 = driver.findElement(By.cssSelector(".flash.success"));
        WebElement resultText2 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));
String actualText = resultText2.getText();
String expectedText = "You logged into a secure area!";

if (actualText.equals(expectedText)){
    System.out.println("Text verification is passed!");
}else{
    System.out.println("Text verification is failed!");
}

        //    Expected: "You logged into a secure area!"

        driver.close();
        driver.quit();
    }
}

package com.cydeo.tests.review.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Navigations_and_getMethod {

    public static void main(String[] args) {

         // 1. Open a chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        // 2. Go to: https://www.etsy.com
        driver.get("https://www.etsy.com");
        driver.manage().window().maximize();

        // 3. Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");

        // 4. Navigate back, forward and refresh
driver.navigate().back();
driver.navigate().forward();
driver.navigate().refresh();
        // 5. Write “selenium” in search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
                searchBox.sendKeys("selenium");
        // 6. Press search button to search
WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
searchButton.click();
        // 7. Verify title is "Amazon.com : selenium"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com : selenium";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is passed!");
        }else{
            System.out.println("Title verification is failed!");
        }
        // 8. Verify url contains "selenium"
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "selenium";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Amazon URL verification is passed ");
        }else{
            System.out.println("Amazon URL verification is failed");
        }

        driver.close();
    }
}

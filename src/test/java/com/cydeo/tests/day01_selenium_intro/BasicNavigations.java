package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //Setup browser driver
        WebDriverManager.chromedriver().setup();

        //Create instance of Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // go to tesla.com
        driver.get("https://www.tesla.com");

        driver.navigate().back();// go back

        Thread.sleep(3000);// stop execution for 3 sec

        driver.navigate().forward();

        Thread.sleep(3000);// stop execution for 3 sec

        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.navigate().to("https://google.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.close();// closes only open tab
        driver.quit();// closes all the windows and tabs
    }
}

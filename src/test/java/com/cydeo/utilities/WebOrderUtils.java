package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.PublicKey;

public class WebOrderUtils {

    //Method #1 info:
    //• Name: returnOrderDate ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName

    public static String returnOrderDate(WebDriver driver,String customerName ){

        return driver.findElement(By.xpath("//td[.='"+ customerName +"']/following-sibling::td[3]")).getText();
    }

    //Method #2 info:
    //• Name: orderVerify ()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //• Arg3: String expectedOrderDate
    public static void orderVerify(WebDriver driver,String customerName,String expectedOrderDate ){
        WebElement customerDateCell= driver.findElement(By.xpath("//td[.='"+ customerName +"']/following-sibling::td[3]"));

        String actualOrderDate = customerDateCell.getText();

        Assert.assertEquals(actualOrderDate, expectedOrderDate);
    }




}

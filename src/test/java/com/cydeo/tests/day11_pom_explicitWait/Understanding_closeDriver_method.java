package com.cydeo.tests.day11_pom_explicitWait;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Understanding_closeDriver_method {

    @Test
    public void test1(){
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().quit();
    }
    @Test
    public void test2(){
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().quit();
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().quit();
    }

}

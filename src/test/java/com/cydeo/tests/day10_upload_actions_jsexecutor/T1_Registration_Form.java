package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form(){
        //TC#1: Registration form confirmation
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
//Driver.getDriver()--> will return "driver"
      Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys("JANE");
        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys("DOE");
        //5. Enter username
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        inputUserName.sendKeys("JANEDOE88");

        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys("janedoe@example.com");

        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys("12345678");

        //8. Enter phone number
        WebElement inputPhoneNum = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhoneNum.sendKeys("444-555-3345");

        //9. Select a gender from radio buttons
        WebElement radioButtonFemale = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        radioButtonFemale.click();

        //10.Enter date of birth
        WebElement inputDOB= Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputDOB.sendKeys("07/23/1966");

        //11.Select Department/Office
      Select departmentDropdown = new Select(Driver.getDriver().findElement(By.name("department")));
      departmentDropdown.selectByValue("DE");

        //12.Select Job Title
Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.name("job_title")));
jobTitleDropdown.selectByVisibleText("SDET");

        //13.Select programming language from checkboxes
      WebElement javaCheckbox = Driver.getDriver().findElement(By.xpath("//input[@value ='java']"));
      javaCheckbox.click();

        //14.Click to sign up button
      WebElement signUpButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
      signUpButton.click();

        //15.Verify success message “You’ve successfully completed registration.” is
        //displayed.
      WebElement successMsg = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
      Assert.assertTrue(successMsg.isDisplayed());
//driver.quit();
      //Driver.getDriver().quit(); --> we don't use this method anymore. Because we want to assign the value back to null
      // So if we have another test, our code can continue executing.
      Driver.closeDriver();

    }
}

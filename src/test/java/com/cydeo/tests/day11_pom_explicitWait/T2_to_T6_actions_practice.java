package com.cydeo.tests.day11_pom_explicitWait;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.accessibility.AccessibleRelation;

public class T2_to_T6_actions_practice {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }
    @Test
    public void  test2_default_value_verification(){
        //TC2 #: Drag and drop default value verification
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles

        //2. Verify big circle default text is as below.

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        String expectedText ="Drag the small circle here.";
        String actualText = bigCircle.getText();
        //3. Assert:
        //-Text in big circle changed to: “Drag the small circle here.”

        Assert.assertTrue(actualText.equals(expectedText));
    }

    @Test
    public void test3_drag_drop_into_big_circle(){
        //TC3 #: Drag and drop into the big circle
        //locating the circles
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        //2. Drag and drop the small circle to bigger circle.

        Actions actions = new Actions(Driver.getDriver());
    //    actions.dragAndDrop(smallCircle, bigCircle).perform();

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .release()
                .perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”

        String expectedText ="You did great!";
        String actualText = bigCircle.getText();
        Assert.assertTrue(actualText.equals(expectedText));
    }

    @Test
    public void test4_click_hold_small_circle(){
        //TC4 #: Click and hold
        //2. Click and hold the small circle.
        //3. Assert:
        //-Text in big circle changed to: “Drop here.”
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .perform();


        String expectedText ="Drop here.";
        String actualText = bigCircle.getText();
        Assert.assertTrue(actualText.equals(expectedText));
    }
     @Test
    public void test5_drop_outside_of_big_circle(){
    //TC5 #: Drag and drop outside of the big circle
    //2. Drag and drop the small circle to bigger circle.
    //3. Assert:
    //-Text in big circle changed to: “Try again!”

    WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
    WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
    WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
    Actions actions = new Actions(Driver.getDriver());
    actions.clickAndHold(smallCircle)
            .pause(1000)
            .moveToElement(cydeoLink)
            .pause(1000)
            .release()
            .perform();

    String expectedText ="Try again!";
    String actualText = bigCircle.getText();
    Assert.assertTrue(actualText.equals(expectedText));
}
    @Test
    public void test6_big_circle_hovering_text_verification(){
        //TC6 #: Drag and hover
       //2. Drag the small circle on top of the big circle, hold it, and verify.
        //3. Assert:
        //-Text in big circle changed to: “Now drop…”


    WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
    WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

    Actions actions = new Actions(Driver.getDriver());
    actions.clickAndHold(smallCircle)
            .pause(1000)
            .moveToElement(bigCircle)
            .pause(1000)
            .perform();

    String expectedText ="Now drop...";
    String actualText = bigCircle.getText();
    Assert.assertTrue(actualText.equals(expectedText));


}

}

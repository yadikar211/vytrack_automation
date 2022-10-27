package com.vytrack.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserUtils {


    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){

        Set<String> allWindowHandles= Driver.getDriver().getWindowHandles();

        for(String eachWindow : allWindowHandles){
            Driver.getDriver().switchTo().window(eachWindow);
            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        String actualTitle =Driver.getDriver().getTitle();
        Assert.assertTrue("Title verification failed!", actualTitle.contains(expectedTitle));
    }


    //Methods are static. Because we do not want to create an object to call those methods.
    // We just want to call those methods with class name. That is why they are static type


    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3);
     * @param seconds
     */
    public static void sleep(int seconds){
        // 1 second = 1000 millis
        // millis = seconds*1000

        try {
            Thread.sleep(seconds*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }


    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }


    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}

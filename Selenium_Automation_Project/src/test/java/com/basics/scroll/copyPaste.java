package com.basics.scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.security.Key;


public class copyPaste {
    WebDriver driver;
@BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException {
       driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
       Thread.sleep(4000);

       Actions action = new Actions(driver);

        WebElement element = driver.findElement(By.id("name"));
        element.sendKeys("Dabarjun");
        Thread.sleep(4000);

        //Select
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        // Copy
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();


        // Tab
        action.sendKeys(Keys.TAB);
        action.build().perform();


        // Paste
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        Thread.sleep(5000);

    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

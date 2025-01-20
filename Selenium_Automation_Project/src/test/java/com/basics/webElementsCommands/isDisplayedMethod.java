package com.basics.webElementsCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class isDisplayedMethod {
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

        WebElement element = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

        try {
            if (element.isDisplayed()) {
                System.out.println(element.getCssValue("color"));
                Thread.sleep(5000);
            }
        }catch(Exception e){
                System.out.println("Element not found");
            }
    }
        @AfterSuite
        public void closeBrowser () {
            driver.quit();
        }

    }
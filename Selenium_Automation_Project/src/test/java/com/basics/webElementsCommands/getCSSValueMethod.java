package com.basics.webElementsCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class getCSSValueMethod {
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
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//input[@class='form-control']"));
        element.sendKeys("Dabarjun Mazumdar");
        Thread.sleep(5000);

        System.out.println(element.getCssValue("color"));

    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

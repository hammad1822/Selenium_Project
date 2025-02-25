package com.basics.assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {
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

        String expectedTitle = "Selenium Practice - Student Registration ";
        String actualTitle = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle);

        WebElement element = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        element.sendKeys("Dabarjun Mazumdar");
        Thread.sleep(3000);

        softAssert.assertAll();

    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

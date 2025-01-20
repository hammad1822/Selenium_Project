package com.basics.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaits {
    WebDriver driver;
    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL(){
     driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Click Button to see alert')]")));
        System.out.println(element.getText());

    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

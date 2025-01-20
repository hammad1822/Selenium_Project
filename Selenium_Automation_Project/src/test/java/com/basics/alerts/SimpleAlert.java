package com.basics.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SimpleAlert {
    WebDriver driver;
    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        Thread.sleep(2000);
//        WebElement alertElement = driver.findElement(By.xpath("//button[@onclick='showAlert()']"));
//        alertElement.click();
//        Thread.sleep(2000);
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        Thread.sleep(3000);
    }
    @Test(priority = 1)
    public void acceptAlert() throws InterruptedException {
        WebElement alertElement = driver.findElement(By.xpath("//button[@onclick='showAlert()']"));
        alertElement.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();
        Thread.sleep(3000);
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

package com.basics.selects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SelectByIndexExample {
    WebDriver driver;
    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
        Thread.sleep(3000);

        WebElement dropdown = driver.findElement(By.id("inputGroupSelect03"));

        Select select = new Select(dropdown);
        select.selectByIndex(4);

        Thread.sleep(3000);

    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

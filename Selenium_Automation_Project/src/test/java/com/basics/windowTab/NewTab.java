package com.basics.windowTab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewTab {
    WebDriver driver;
    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void openURL() throws InterruptedException {
        driver.get("https://mvnrepository.com/");
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void createNewTab() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

package com.basics.windowTab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class CountTab {
    WebDriver driver;

    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);
    }
    @Test(priority = 1)
    public void countTabNumber() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.selenium.dev/documentation/");
        Thread.sleep(3000);

        Set<String> tabs = driver.getWindowHandles();
        System.out.println("Number of Tabs " + tabs.size());
    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

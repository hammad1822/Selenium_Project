package com.basics.scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SpecificLocatorScroll {

    WebDriver driver;
    @BeforeSuite
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//div[@class='facebook-fanbox']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
        Thread.sleep(4000);

    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

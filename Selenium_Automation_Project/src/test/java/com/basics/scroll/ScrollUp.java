package com.basics.scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScrollUp {

    WebDriver driver;
    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php?id_category=3&controller=category");
        Thread.sleep(4000);

        //Scroll Down Of a Website
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "window.scrollTo(0, document.body.scrollHeight)" ;
        js.executeScript(script);
        Thread.sleep(4000);

        //Scroll Up of a Website
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(4000);


    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
